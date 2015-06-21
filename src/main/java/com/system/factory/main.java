package com.system.factory;


import com.system.service.ServiceGeneration;

import java.sql.Date;

/**
 * Created by home on 21.06.15.
 */

public class main{

    public static void main(String[] args) {

        long numberUser = Long.parseLong(args[0]);
        String[] test = args[1].split("-");
        Date dateStart = new Date(Integer.parseInt(test[0]) - 1900, Integer.parseInt(test[1]) - 1, Integer.parseInt(test[2]));
        test = args[2].split("-");
        Date dateEnd = new Date(Integer.parseInt(test[0]) - 1900, Integer.parseInt(test[1]) - 1, Integer.parseInt(test[2]));
        String url = args[3];
        String username = args[4];
        String password = args[5];

        ServiceGeneration.start(numberUser, dateStart, dateEnd, url, username, password);

       // ServiceGeneration.start(200, new Date(20190210), new Date(20130203), "jdbc:mysql://localhost:3306/database2", "root", "password");
    }

}
