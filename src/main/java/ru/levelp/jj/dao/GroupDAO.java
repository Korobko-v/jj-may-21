package ru.levelp.jj.dao;

import ru.levelp.jj.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class GroupDAO {
    private final EntityManager manager;

    public GroupDAO(EntityManager manager) {
        this.manager = manager;
    }

    public Group create(String groupName) {
        Group group = new Group(groupName);
        manager.getTransaction().begin();
        try {
            manager.persist(group);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        return group;
    }

    public Group findByName(String groupName) {

        try {
            return manager.createNamedQuery("findByName", Group.class)
                    .setParameter("groupName", groupName)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Group> findBigGroups(int minMembersCount) {
       return manager.createQuery("from Group g where size(g.users) >= :min", Group.class)
                .setParameter("min", minMembersCount)
                .getResultList();
    }
}
