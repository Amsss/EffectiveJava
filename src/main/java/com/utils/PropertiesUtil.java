package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-09 14:49
 */
public class PropertiesUtil {
    private static String propertiesUrl = "../hadoop.properties";
    private static Properties props = new Properties();

    static {
        try {

            InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesUrl);
            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readValue(String key) {
        String value = props.getProperty(key);
        return value;
    }

    @SuppressWarnings("rawtypes")
    public static void readProperties() {
        try {
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String Property = props.getProperty(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeProperties(String parameterName, String parameterValue) {
        try {
            OutputStream fos = new FileOutputStream(propertiesUrl);
            props.setProperty(parameterName, parameterValue);
            props.store(fos, "Update '" + parameterName + "' value");
        } catch (IOException e) {
            System.err.println("Visit " + propertiesUrl + " for updating " + parameterName + " value error");
        }
    }
}
