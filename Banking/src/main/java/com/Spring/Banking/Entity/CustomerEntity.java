package com.Spring.Banking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="customer")
public class CustomerEntity {
    @Id
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

    public CustomerEntity(int id,String name, int age, String account) {
        this.id =id;
        this.name = name;
        this.age = age;
        this.account = account;
    }
    public CustomerEntity(){

    }
    public void setAccount(String account) {
        this.account = account;

    }

}
