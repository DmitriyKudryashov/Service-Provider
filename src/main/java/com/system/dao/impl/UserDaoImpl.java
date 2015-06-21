package com.system.dao.impl;

import com.system.dao.UserDao;
import com.system.domain.User;
import com.system.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by home on 21.06.15.
 */


public class UserDaoImpl implements UserDao{

    @Override
    public void add(User user) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.getMessage();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void update() {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(User.class);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.getMessage();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<User> gets() {
        List<User> userList = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            userList = session.createCriteria(User.class).list();
        }catch (Exception ex){
            ex.getMessage();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return userList;
    }

}
