package com.Spring.Banking.ExceptionHandler;

public class CustomerNotFoundException extends RuntimeException{
    private String msg;
    public CustomerNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
    CustomerNotFoundException(){};
}
