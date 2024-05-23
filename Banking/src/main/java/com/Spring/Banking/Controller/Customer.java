package com.Spring.Banking.Controller;

import org.springframework.stereotype.Component;

//@Component
public class Customer {

    public void welcome(){
        System.out.println("Welcome to baking application");
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

    public Customer(String name, int age, String account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public void setAccount(String account) {
        this.account = account;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account='" + account + '\'' +
                '}';
    }
}
