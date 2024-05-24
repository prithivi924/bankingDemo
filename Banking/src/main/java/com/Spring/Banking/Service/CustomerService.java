package com.Spring.Banking.Service;

import com.Spring.Banking.Pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    ArrayList<Customer> customers = new ArrayList<Customer>();
    public Customer getCustomerById(int id){
        Customer output = new Customer();
        for(Customer customer : customers){
            if(customer.getId()== id){
               output=customer;
            }
        }
        return output;
    }

    public String addCustomer(Customer cust){
        customers.add(cust);
        return "Customer Added Successfully";
    }

    public List<Customer> getAllCustomer() {
        return customers;
    }

    public String updateCustomer(int id,String name){
        for(Customer customer : customers){
            if(customer.getId()== id){
                customer.setName(name);
                return  "Customer "+customer.getName()+" updated successfully for this Id: "+customer.getId();
            }
        }
    return "customer not found";
    }

}
