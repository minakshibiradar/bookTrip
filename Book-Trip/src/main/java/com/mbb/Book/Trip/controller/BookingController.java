package com.mbb.Book.Trip.controller;

import com.mbb.Book.Trip.request.BookingRequest;
import com.mbb.Book.Trip.response.BookingResponse;
import com.mbb.Book.Trip.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("addBooking/{customerId}")
    public BookingResponse addBookingOfCustomer(@RequestBody BookingRequest bookingRequest,
                                                @PathVariable("customerId") int customer){
        return bookingService.addBookingOfCustomer(bookingRequest,customer);

    }






}
