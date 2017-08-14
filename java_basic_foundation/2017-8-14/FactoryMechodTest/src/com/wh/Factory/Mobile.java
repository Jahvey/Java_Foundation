package com.wh.Factory;

public class Mobile implements  Bicycle {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(this.name+"可以跑了...");
    }
}
