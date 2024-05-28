package com.Spring.Banking;

import com.Spring.Banking.Controller.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankingApplication {

	//public static  Customer customer;
	public static Logger logger = LoggerFactory.getLogger(BankingApplication.class);
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);

		/*Customer cust= context.getBean(Customer.class);
		cust.welcome();*/
		//System.out.println("Application Started");

		logger.info("Application Started");

	}

}
