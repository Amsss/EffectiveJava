package com.framework.serviceprovider;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: 服务提供者框架
 * @author: zhuzz
 * @date: 2019/1/3 16:25
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                DriverManager.getConnection("jdbc:mysql://localhost:3306/serialization", "root", "123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Services.registerDefaultProvider(new ProviderImpl());
        Services.newInstance();
    }
}
