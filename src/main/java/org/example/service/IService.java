package org.example.service;

import org.example.domain.User;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Kuzmin Evgeny on 19.05.2017.
 */
public interface IService {
    void persist(Object object);
    void update(Object object);
    public void delete(Object entity);
    public <T> void deleteAll(String tableName);
    public <T> T find(Class<T> entityClass, Object primaryKey);
    public <T> List<T> findAll(String tableName);
    public User isExist(String name, String password);
    public User isExist(String name);
    public <T> T merge(T entity);
}
