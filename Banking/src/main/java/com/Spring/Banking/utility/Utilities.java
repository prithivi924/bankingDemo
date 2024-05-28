package com.Spring.Banking.utility;

import com.Spring.Banking.Entity.CustomerEntity;
import com.Spring.Banking.Pojo.Customer;

public class Utilities {

    public static Customer convertToCustomer(CustomerEntity entity){

        if (entity != null) {
            Customer customer = new Customer(entity.getId(),  entity.getName(),entity.getAge(),entity.getAccount());
            return customer;
        }
        else {
            throw new NullPointerException("customer Entity is null");
        }
    }

    public static CustomerEntity convertToEntity(Customer customer){

        if (customer != null) {
            CustomerEntity customerEntity = new CustomerEntity(customer.getId(),  customer.getName(),customer.getAge(),customer.getAccount());
            return customerEntity;
        }
        else {
            throw new NullPointerException("customer Entity is null");
        }
    }



}
