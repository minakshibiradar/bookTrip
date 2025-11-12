package com.mbb.Book.Trip.exception;

public class DriverNotFoundException extends  RuntimeException{
    public  DriverNotFoundException(String message){
        super(message);
    }
}
