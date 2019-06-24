package com.annotation;

/**
 * @author: zhuzz
 * @description: OpenSource类
 * @date: 2018/10/4 19:55
 */
@Description("OpenSource, You are what you read.")
public class OpenSource {

    @Name(originate = "地区：China", community = "社区: sky")
    public String getName1() {
        return null;
    }

    @Name(originate = "地区：America", community = "社区: sky")
    public String getName2() {
        return "Helloworld!";
    }
} 

