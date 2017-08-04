package com.pkaleta.todoapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
/**
 * 
 * @author pkaleta
 *
 * Interface provides connection and basic operations on db.
 */
public abstract class AbstractDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    /**
     * Get session to operate on db
     * @return session
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    /**
     * Save entity to db
     * @param entity Entity object to save in db
     */
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    /**
     * Delete entity from db
     * @param entity Entity object to delete from db
     */
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}