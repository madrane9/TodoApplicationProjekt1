package com.qacart.todo.testcases;

import java.io.*;
import java.util.Properties;

public class Dummy {
    public static void main(String[] args) throws IOException {
        File file = new File("src/test/java/com/qacart/todo/config/production.properties");
        InputStream inputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(inputStream);
        String baseUrl = properties.getProperty("baseUrl");

        System.out.println(baseUrl);
    }
}
