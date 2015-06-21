package com.system.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Created by home on 21.06.15.
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(String url, String username, String password) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.addResource("user.xml");
        configuration.addResource("downloadInformation.xml");

        HibernateUtil.sessionFactory = configuration.buildSessionFactory();

    }



}
