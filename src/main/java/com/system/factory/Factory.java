package com.system.factory;

import com.system.dao.DownloadInformationDao;
import com.system.dao.UserDao;
import com.system.dao.impl.DownloadInformationDaoImpl;
import com.system.dao.impl.UserDaoImpl;

/**
 * Created by home on 21.06.15.
 */


public class Factory {

    private static Factory instance = new Factory();

    private UserDao user;
    private DownloadInformationDao downloadInformationDao;

    public UserDao getUserDao() {
        if (user ==  null){
            user = new UserDaoImpl();
        }
        return user;
    }

    public DownloadInformationDao getDownloadInformationDao() {
        if (downloadInformationDao == null){
            downloadInformationDao = new DownloadInformationDaoImpl();
        }
        return downloadInformationDao;
    }

    public static Factory getInstance() {
        return instance;
    }


}
