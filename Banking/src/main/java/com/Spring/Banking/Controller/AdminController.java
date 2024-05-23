package com.Spring.Banking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
   // @Autowired
    //public Customer customer;

    @GetMapping("/first")
    public String firstRequest(@RequestParam String name){
        //customer.welcome();
        return "Welcome "+ name;
    }

    @GetMapping("/add")
    public String addition(@RequestParam int a,@RequestParam int b){
             return "the sum is "+ (a+b);
    }

    @GetMapping("/customer")
    public String viewCustomer(@RequestBody Customer cust){
            return cust.toString();


    }


}
