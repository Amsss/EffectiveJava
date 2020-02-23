package com.utils;

import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-30 17:17
 */
public class ClobUtil {
    static String url = "jdbc:oracle:thin:@10.12.10.18:1521:orcl";
    static String user = "cwbe1_9999";
    static String pwd = "or777";
    static String text = "这是要插入到CLOB里面的数据,更新数据！" + "update";
    private static String driver = "oracle.jdbc.driver.OracleDriver";

    private static int clobImport() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, pwd);// 得到连接对象
        String sql = "insert into ETLNEEDPARAM(F_KEY,F_VALUE) values ('defaultpo',?)";// 要执行的SQL语句
        String sql1 = "update ETLNEEDPARAM set F_VALUE = ? where F_KEY = ? ";// 要执行的SQL语句
        PreparedStatement stmt = conn.prepareStatement(sql);// 加载SQL语句
        // PreparedStatement支持SQL带有问号？，可以动态替换？的内容。
        Reader clobReader = new StringReader(text); // 将 text转成流形式
        stmt.setCharacterStream(1, clobReader, text.length());// 替换sql语句中的？
        int num = stmt.executeUpdate();// 执行SQL
        if (num > 0) {
            System.out.println("ok");
        } else {
            System.out.println("NO");
        }
        stmt.close();
        conn.close();
        return num;
    }

    public static void main(String[] args) {
        try {
            clobImport();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
