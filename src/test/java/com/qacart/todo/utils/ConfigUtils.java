package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    private  Properties properties;
    private static ConfigUtils configUtils;

    public ConfigUtils(){
        properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
    }

    public static ConfigUtils getInstance (){
        if(configUtils == null)
        {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public  String getBaseUrl(){
        String prop = properties.getProperty("baseurl");
        if(prop != null) return prop;
            throw new RuntimeException("Could not find the base url in the property file");
    }
}
