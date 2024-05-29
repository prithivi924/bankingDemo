package com.Spring.Banking.Pojo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

//@Component

public class Customer {

    public Customer() {

    }

    public void welcome(){
        System.out.println("Welcome to baking application");
    }
    private int id;
    @NotBlank(message = "Name is mandatory,please enter name")
    private String name;
    @Min(18)
    @Max(98)
    private int age;
    @NotBlank(message = "Account type is mandatory,please enter ")
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;

    }


}
