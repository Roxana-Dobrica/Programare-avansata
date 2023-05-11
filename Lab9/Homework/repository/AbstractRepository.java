package org.example.repository;

import org.example.manager.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractRepository<T> {

    protected EntityManager entityManager;

    public AbstractRepository(EntityManagerFactory emf)
    {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T findById(Long id) {

        return entityManager.find(getEntityClass(), id);
    }

    public List<T> findByName(String namePattern) {

        return entityManager.createNamedQuery(getEntityClass().getSimpleName() + ".findByName")
                            .setParameter("name", "%" + namePattern +"%")
                            .getResultList();
    }
    public void close()
    {

        entityManager.close();
    }

    protected abstract Class<T> getEntityClass();
}
