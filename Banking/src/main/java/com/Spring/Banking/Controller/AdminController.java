package com.Spring.Banking.Controller;

import com.Spring.Banking.Pojo.Customer;
import com.Spring.Banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    public CustomerService service;

    @GetMapping("/first")
    public String firstRequest(@RequestParam String name) {
        //customer.welcome();
        return "Welcome " + name;
    }

    @GetMapping("/add")
    public String addition(@RequestParam int a, @RequestParam int b) {
        return "the sum is " + (a + b);
    }

    @GetMapping("/customer")
    //get a specific customer object by passing their Id
    public Customer viewCustomer(@RequestParam int id) {
        return service.getCustomerById(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @GetMapping("/getAllCustomer")
    //get all  customer object
    public List<Customer> getAllCustomer() {
        return service.getAllCustomer();
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestParam int id, @RequestParam String name) {
        return service.updateCustomer(id, name);
    }

}