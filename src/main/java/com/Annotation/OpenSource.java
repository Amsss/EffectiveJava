package com.Annotation;

@Description("OpenSource,You are what you read.")
public class OpenSource {
    @Name(originate = "主办方：China", community = "sky")
    public String getName() {
        return null;
    }

    @Name(originate = "主办方：America", community = "sky")
    public String getName2() {
        return "Helloworld!";
    }
} 

