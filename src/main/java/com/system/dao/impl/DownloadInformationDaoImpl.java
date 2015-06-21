package com.system.dao.impl;

import com.system.dao.DownloadInformationDao;
import com.system.domain.DownloadInformation;
import com.system.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by home on 21.06.15.
 */

public class DownloadInformationDaoImpl implements DownloadInformationDao {

    @Override
    public void add(DownloadInformation downloadInformation) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(downloadInformation);
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
            session.update(DownloadInformation.class);
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
    public List<DownloadInformation> gets() {
        List<DownloadInformation> downloadInformationList = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            downloadInformationList = session.createCriteria(DownloadInformation.class).list();
        }catch (Exception ex){
            ex.getMessage();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return downloadInformationList;
    }

}
