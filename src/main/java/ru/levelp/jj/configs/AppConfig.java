package ru.levelp.jj.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "ru.levelp.jj")
public class AppConfig {
    @Bean
    public EntityManagerFactory factory() {
        return Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }
}
