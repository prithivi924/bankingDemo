package com.Spring.Banking.Controller;

import com.Spring.Banking.Pojo.Customer;
import com.Spring.Banking.Service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    public CustomerService service;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

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
        logger.info("entered in get Request for returning an customer object",id);
        logger.info("Customer Object: "+service.getCustomerById(id).toString());
        return service.getCustomerById(id);
    }

    @GetMapping("/customerName")
    //get a specific customer object by passing their Name
    public Customer getCustomerName(@RequestParam String name) {
        logger.info("entered in get Request for returning an customer object",name);
        logger.info("Customer Object: "+service.getCustomerByName(name).toString());
        return service.getCustomerByName(name);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody @Valid Customer customer) {
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