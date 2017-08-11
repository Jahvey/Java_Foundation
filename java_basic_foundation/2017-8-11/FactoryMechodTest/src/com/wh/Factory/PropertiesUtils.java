package com.wh.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 读取Properties文件夹的工具类
 *
 * */
public class PropertiesUtils {
    /**
     *
     * 读取Properties对应的value的值
     *读取对应value的工具类
     * */
    public static String getPropertyValue(String key)throws  Exception{

        Properties properties=new Properties();
        String path=PropertiesUtils.class.getClassLoader()//
                .getResource("Bicycle.properties").getPath();

        InputStream is=new FileInputStream(new File(path));
        properties.load(is);
        String value=properties.getProperty(key);
        is.close();
        return value;


    }






}
