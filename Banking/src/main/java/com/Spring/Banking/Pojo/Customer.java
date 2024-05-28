package com.Spring.Banking.Pojo;

import org.springframework.stereotype.Component;

//@Component
public class Customer {

    public Customer() {

    }

    public void welcome(){
        System.out.println("Welcome to baking application");
    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int age;
    private String account;

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

    public String getAccount() {
        return account;
    }

    public Customer(int id, String name, int age, String account) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public void setAccount(String account) {
        this.account = account;

    }


}
