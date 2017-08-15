package com.wh.mysql;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private int age;
    private Date date;
    private String gender;
    private String address;

    public Student(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Student(int id, String name, int age, Date date, String gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date = date;
        this.gender = gender;
        this.address = address;
    }
}
