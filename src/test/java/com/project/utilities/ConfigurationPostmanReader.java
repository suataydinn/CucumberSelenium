package com.project.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationPostmanReader {

    private static Properties properties;

    static {

        try {
            String path = "postman.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}