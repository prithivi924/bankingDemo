package com.Spring.Banking.Controller;

import com.Spring.Banking.Pojo.Customer;
import com.Spring.Banking.Service.CustomerService;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    public CustomerService service;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/")
    public String index() {
        //customer.welcome();
        return "index";
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

    @GetMapping("/emptyCustomerPage")
    public String returnEmptyPage(Model model){
       Customer customer = new Customer();
       model.addAttribute("cust",customer);
       return "CustomerInsert";
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("cust") @Valid Customer customer) {
         service.addCustomer(customer);
        return "successInsert";
    }
    @GetMapping("/customerName")
    //get a specific customer object by passing their Name
    public Customer getCustomerName(@RequestParam String name) {
        logger.info("entered in get Request for returning an customer object",name);
        logger.info("Customer Object: "+service.getCustomerByName(name).toString());
        return service.getCustomerByName(name);
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