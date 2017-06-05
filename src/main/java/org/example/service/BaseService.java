package org.example.service;

import org.example.dao.BaseDao;
import org.example.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kuzmin Evgeny on 17.05.2017.
 * Сервис, который реализует интерфейс - {@link IService}
 * работает с объектом класса {@link BaseDao} для осуществления взаимодействия с базой данных.
 */
public class BaseService implements IService {

    private static final BaseDao baseDao = new BaseDao();

    @Override
    public void persist(Object object) {
        baseDao.openCurrentManagerWithTransaction();
        baseDao.persist(object);
        baseDao.closeCurrentManagerWithTransaction();
    }

    @Override
    public void update(Object object) {
        baseDao.openCurrentManagerWithTransaction();
        baseDao.update(object);
        baseDao.closeCurrentManagerWithTransaction();
    }

    @Override
    public void delete(Object entity) {
        baseDao.openCurrentManagerWithTransaction();
        baseDao.delete(entity);
        baseDao.closeCurrentManagerWithTransaction();
    }

    @Override
    public <T> void deleteAll(String tableName) {
        baseDao.openCurrentManagerWithTransaction();
        baseDao.deleteAll(tableName);
        baseDao.closeCurrentManagerWithTransaction();
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        baseDao.openCurrentManagerWithTransaction();
        T entity = baseDao.find(entityClass, primaryKey);
        baseDao.closeCurrentManagerWithTransaction();
        return entity;
    }

    @Override
    public <T> List<T> findAll(String tableName) {
        baseDao.openCurrentManagerWithTransaction();
        List<T> list = baseDao.findAll(tableName);
        baseDao.closeCurrentManagerWithTransaction();
        return list;
    }

    @Override
    public org.example.domain.User isExist(String name, String password) {
        EntityManager entityManager = baseDao.openCurrentManagerWithTransaction();
        List<org.example.domain.User> list = entityManager.createQuery("from User where name = :name and password = :password ", org.example.domain.User.class)
                .setParameter("name", name)
                .setParameter("password", password)
                .getResultList();
        baseDao.closeCurrentManagerWithTransaction();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public org.example.domain.User isExist(String name) {
        EntityManager entityManager = baseDao.openCurrentManagerWithTransaction();
        List<org.example.domain.User> list = entityManager.createQuery("from User where name = :name", org.example.domain.User.class)
                .setParameter("name", name)
                .getResultList();
        baseDao.closeCurrentManagerWithTransaction();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public <T> T merge(T entity) {
        baseDao.openCurrentManagerWithTransaction();
        T mergedEntity = baseDao.merge(entity);
        baseDao.closeCurrentManagerWithTransaction();
        return mergedEntity;
    }
}
