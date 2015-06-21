package com.system.service;

import com.system.dao.DownloadInformationDao;
import com.system.dao.UserDao;
import com.system.domain.DownloadInformation;
import com.system.domain.User;
import com.system.factory.Factory;
import com.system.hibernateUtil.HibernateUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

/**
 * Created by home on 21.06.15.
 */

public class ServiceGeneration {
    private static final String arrayChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();
    private static UserDao userDao;
    private static DownloadInformationDao downloadInformationDao;

    public static void start(long numberUser, Date dateStart, Date dateEnd, String url, String username, String password){
        HibernateUtil.setSessionFactory(url, username, password);

        userDao = Factory.getInstance().getUserDao();
        downloadInformationDao = Factory.getInstance().getDownloadInformationDao();

        addUsers(numberUser, dateStart, dateEnd);
    }

    private static void addUsers(long numberUser, Date dateStart, Date dataEnd){
        User user = null;
        DownloadInformation downloadInformation = null;

        for (long i = 0; i < numberUser; ++i){
            long rndByte = generationResultByte();
            user = new User(generationUsername());
            downloadInformation = new DownloadInformation(dateStart, dataEnd, (rndByte < 0 ? rndByte * (-1) : rndByte));

            user.addDownloadInformation(downloadInformation);

            userDao.add(user);
        }
    }

    private static String generationUsername(){
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < (random.nextInt(7 - 4) + 4); ++i){
            randStr.append(arrayChar.charAt(random.nextInt(arrayChar.length())));

        }
        return randStr.toString();
    }

    private static long generationResultByte(){
        return random.nextLong();
    }

}
