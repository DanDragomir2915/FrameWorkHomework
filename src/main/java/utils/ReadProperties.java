package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties config = loadProperties("properties/config.properties");

    public static Properties loadProperties(String filePath){
        Properties properties = new Properties();


        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);

        }catch(Exception e){
            e.printStackTrace();

        }
        return properties;
    }
}
