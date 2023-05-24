package com.store.utilities;

import org.apache.commons.io.FilenameUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    String path = "src/test/resources/Configuration/config.properties";

    public ReadConfig() {
        try{
            properties = new Properties();
            System.out.println(path);
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getBaseURL(){
        String URL =  properties.getProperty("baseURL");
        System.out.println(System.getProperty("user.dir"));
        if(URL!=null){
            return URL;
        }else{
            throw new RuntimeException("URL not found in the config file");
        }
    }

    public String getBrowser(){
        String browseName =  properties.getProperty("browser");
        if(browseName!=null){
            return browseName;
        }else{
            throw new RuntimeException("browser name not found in the config file");
        }
    }
}
