package com.wh.Factory;

public class Huang implements Bicycle {


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(){
        System.out.println(this.name+"生产出来了。。。。");

    }

}

