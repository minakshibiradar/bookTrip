package com.mbb.Book.Trip.controller;


import com.mbb.Book.Trip.Enum.Gender;
import com.mbb.Book.Trip.model.Customer;
import com.mbb.Book.Trip.request.CustomerRequest;
import com.mbb.Book.Trip.response.CustomerResponse;
import com.mbb.Book.Trip.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService serv;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return serv.addCustomer(customerRequest);


    }
    @GetMapping("/getbyid/{id}")
    public CustomerResponse getById(@PathVariable("id") int customerId){
        return serv.getById(customerId);
    }

    @GetMapping("/getByGenderAge")
    public List<CustomerResponse> getByGenderAndAge(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age){
        return serv.getByGenderandAge(gender,age);

    }

    @GetMapping("/getByGenderAndAgeGreaterThan")
    public List<CustomerResponse> getByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age){
        return serv.getByGenderandAgeGreaterThan(gender,age);

    }

    @GetMapping("/getGenderAndAgeGreaterThanUsingSQL")
    public List<CustomerResponse> getByGenderAndAgeGreaterThanUsingSql(@RequestParam("gender") String gender,
                                                               @RequestParam("age") int age){
        return serv.getByGenderandAgeGreaterThanUsingSQL(gender,age);


    }
//    find out customer who have more than two bookings in one single day
      @GetMapping("/customerMoreThanTwoBookings")
      public List<Customer> getCustomerMoreThanTwoBooking(@RequestParam("date") Date date){
        return serv.getCustomerMoreThanTwoBooking(date);

      }

}
