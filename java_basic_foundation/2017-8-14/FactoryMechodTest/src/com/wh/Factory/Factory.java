package com.wh.Factory;


/**
 *
 这里测试的是如何把反射模式应用到properties，实例化工厂模式对象的实例
 * */

public class Factory {


    private static  Bicycle getInstance(String path)throws  Exception{
        Bicycle bicycle=null;

        bicycle=(Bicycle)Class.forName(PropertiesUtils.getPropertyValue(path)).newInstance();
        //bicycle.move();


        return bicycle;



    }


    public static void main(String[] args) {
        try {
            Huang bicycle= (Huang) Factory.getInstance("huang");
            bicycle.setName("小黄车");
            bicycle.move();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
