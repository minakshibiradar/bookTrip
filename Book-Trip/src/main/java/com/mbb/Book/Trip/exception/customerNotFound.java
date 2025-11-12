package com.mbb.Book.Trip.exception;

public class customerNotFound extends RuntimeException{

    public customerNotFound(String meassage){
        super(meassage);
    }
}
