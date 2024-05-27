package com.Spring.Banking.Service;

import com.Spring.Banking.Entity.CustomerEntity;
import com.Spring.Banking.Pojo.Customer;
import com.Spring.Banking.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;
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
        //customers.add(cust);
        CustomerEntity object = new CustomerEntity(cust.getId(),cust.getName(),cust.getAge(),cust.getAccount());
        repo.save(object);//inserting entity object into the table.
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
