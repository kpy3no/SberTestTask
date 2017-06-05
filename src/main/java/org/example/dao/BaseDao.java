package org.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kuzmin Evgeny on 17.05.2017.
 */
public class BaseDao  {
    private EntityManager entityManager;

    public EntityManager openCurrentManager(){
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        return entityManager;
    }

    public EntityManager openCurrentManagerWithTransaction(){
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    public void closeCurrentManager(){
        entityManager.close();
    }

    public void closeCurrentManagerWithTransaction(){
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void persist(Object entity) {
       getEntityManager().persist(entity);
    }


    public <T> T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Object entity) {
        getEntityManager().remove(entity);
    }

    public <T> void deleteAll(String tableName) {
        List<T> entityList = findAll(tableName);
        for (T entity : entityList){
            delete(entity);
        }
    }

    public <T> T find(Class<T> entityClass, Object primaryKey){
        return getEntityManager().find(entityClass, primaryKey);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(String tableName) {
        List<T> list = getEntityManager()
                .createQuery("from " + tableName).getResultList();
        return list;
    }

    public <T> T merge(T entity){
        return getEntityManager().merge(entity);
    }

}
