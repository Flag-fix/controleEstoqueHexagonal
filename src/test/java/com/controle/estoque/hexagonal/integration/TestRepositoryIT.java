package com.controle.estoque.hexagonal.integration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ActiveProfiles("it")
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestEntityManager
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public abstract class TestRepositoryIT {

    @Autowired
    protected TestEntityManager em;

    @SuppressWarnings("unchecked")
    protected <T> T findFirst(Class<T> entity) {
        return (T) em.getEntityManager()
                     .createQuery("FROM " + entity.getName())
                     .setMaxResults(1)
                     .getSingleResult();
    }

    protected <T> List<T> findAll(Class<T> entity) {
        return em.getEntityManager()
            .createQuery("FROM " + entity.getName())
            .getResultList();
    }
}