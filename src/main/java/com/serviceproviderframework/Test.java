package com.serviceproviderframework;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2017-10-27 上午10:18:59
 */
public class Test {
    public static void main(String[] args) {
        //服务提供者框架
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Services.registerDefaultProvider(new ProviderImpl());
        Services.newInstance();
    }
}
