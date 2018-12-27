package com.Annotation;

/**
 * @author: zhuzz
 * @description: 描述
 * @date: 2018/10/4 19:55
 */
@Description("OpenSource,You are what you read.")
public class OpenSource {

    @Name(originate = "主办方：China", community = "sky")
    public String getName1() {
        return null;
    }

    @Name(originate = "主办方：America", community = "sky")
    public String getName2() {
        return "Helloworld!";
    }
} 

