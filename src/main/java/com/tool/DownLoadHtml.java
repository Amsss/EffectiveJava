package com.tool;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @description: 下载指定网页的html源码
 * @author: zhuzz
 * @date: 2018/5/24 18:12
 */
public class DownLoadHtml {

    public static void main(String[] args) {
        String pageURL = "https://m.8wenku.com/chapter/view?id=1690&chapter_no=20";
        String filePath = "D:/3.html";
        try {
            downHTML(pageURL, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("下载HTML页面完成");
    }

    private static void downHTML(String pageURL, String filePath) throws IOException {
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        try {
            fileWriter = new FileWriter(filePath);
            URL url = new URL(pageURL);
            //打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置请求属性
            connection.setRequestProperty("User-Agent", "MSIE 7.0");
            //建立实际的连接
            connection.connect();
            //解析出页面编码方案，解析不到，采用gb2312
            Map<String, List<String>> map = connection.getHeaderFields();
            List<String> contentTypelist = map.get("Content-Type");
            String[] contents = contentTypelist.get(0).split("; ");
            String encoding;
            if (contents.length == 1) {
                encoding = "gb2312";
            } else {
                encoding = contents[1].substring(contents[1].indexOf("=") + 1);
            }
            //建立带缓冲的字符输入流
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            String line;
            //不断读取，直至读到结尾
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line + "\r\n");
            }
            //断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}
