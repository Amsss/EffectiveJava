package com.json.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-30 16:55
 */
public class FirstDemo {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * JSON格式字符串与JSON对象之间的转换
     * json字符串-简单对象型到JSONObject的转换
     */
    public static void jsonStrToJsonObject() {
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        System.out.println("studentName:  " + jsonObject.getString("studentName"));
        System.out.println("studentAge:  " + jsonObject.getInteger("studentAge"));
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * JSONObject到json字符串-简单对象型的转换
     */
    public static void jSONObjectToJSONStr() {
        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        // 第一种方式
        String jsonString = JSONObject.toJSONString(jsonObject);
        // 第二种方式
        String jsonString2 = jsonObject.toJSONString();
        System.out.println(jsonString);
        System.out.println(jsonString2);
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * json字符串-数组类型到JSONArray的转换
     */
    public void jSONStrToJSONArray() {
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * JSONArray到json字符串-数组类型的转换
     */
    public void jSONArrayToJSONStr() {
        //已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
        String jsonString = JSONArray.toJSONString(jsonArray);
        System.out.println(jsonString);
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * 复杂json格式字符串到JSONObject的转换
     */
    public void complexJSONStrToJSONObject() {
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);
        JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
        //获取JSONObject中的数据
        String courseName = jsonObjectcourse.getString("courseName");
        Integer code = jsonObjectcourse.getInteger("code");
        System.out.println("courseName:  " + courseName + "   code:  " + code);
        JSONArray jsonArraystudents = jsonObject.getJSONArray("students");
        // 遍历JSONArray
        for (Object object : jsonArraystudents) {
            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");
            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
        }
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * 复杂JSONObject到json格式字符串的转换
     */
    public void jSONObjectToComplexJSONStr() {
        //复杂JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
        //第一种方式
        String jsonString1 = JSONObject.toJSONString(jsonObject);
        //第二种方式
        String jsonString2 = jsonObject.toJSONString();
        System.out.println(jsonString1);
        System.out.println(jsonString2);
    }

    public static void main(String[] args) {
        jsonStrToJsonObject();
        jSONObjectToJSONStr();
    }
}
