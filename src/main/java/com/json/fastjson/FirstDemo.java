package com.json.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-10-30 16:55
 */
public class FirstDemo {

    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * json字符串-简单对象型到JSONObject的转换
     */
    public void jsonStrToJsonObject() {

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));

    }

    /**
     * JSONObject到json字符串-简单对象型的转换
     */
    public void testJSONObjectToJSONStr() {

        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        // 第一种方式
        String jsonString = JSONObject.toJSONString(jsonObject);

        // 第二种方式
        //String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
    }

    public static void main(String[] args) {

    }
}
