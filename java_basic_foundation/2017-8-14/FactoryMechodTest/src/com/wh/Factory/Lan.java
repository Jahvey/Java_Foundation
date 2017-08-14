package com.wh.Factory;

public class Lan implements  Bicycle {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public void move() {

        System.out.println(this.name);

    }
}
