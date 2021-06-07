package ru.levelp.jj.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.jj.model.Group;
import ru.levelp.jj.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class UsersDAOTest {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private UsersDAO users;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
        users = new UsersDAO(manager);
    }

    @After
    public void tearDown() throws Exception {
        if (manager != null) {
            manager.close();
        }

        if (factory != null) {
            factory.close();
        }
    }

    @Test
    public void create() {
        User createdUser = users.create("login1" , "pass");
        assertNotNull(createdUser);

        assertEquals(createdUser, manager.find(User.class, createdUser.getId()));
        assertEquals(createdUser, users.findById(createdUser.getId()));
        assertNull(users.findById(39149));
    }

    @Test
    public void findByLoginExisting() {
        User createdUser = users.create("login2", "pass");
        assertEquals(createdUser, users.findByLogin("login2"));
    }

    @Test
    public void findByLoginNotExisting() {
        User createdUser = users.create("login2", "pass");
        assertNull(users.findByLogin("login3"));
    }

    @Test
    public void findByLoginAndPassword() {
        User createdUser = users.create("login3", "pass");
        assertEquals(createdUser, users.findByLoginAndPassword("login3", "pass"));
        assertNull(users.findByLoginAndPassword("login8", "pass3"));
    }

    @Test
    public void findByGroupName() {
        User createdUser = new User("login4", "pass");

        Group group = new Group("my_group");
        manager.getTransaction().begin();
        manager.persist(group);
        manager.persist(createdUser);
        createdUser.setGroup(group);
        manager.getTransaction().commit();

        assertEquals(Collections.singletonList(createdUser), users.findByGroupName("my_group"));
        assertEquals(Collections.emptyList(), users.findByGroupName("my_groupp"));
    }
}