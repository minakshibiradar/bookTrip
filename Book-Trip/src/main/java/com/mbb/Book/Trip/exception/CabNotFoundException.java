package com.mbb.Book.Trip.exception;

public class CabNotFoundException extends RuntimeException{

    public CabNotFoundException(String message){
        super(message);
    }
}
