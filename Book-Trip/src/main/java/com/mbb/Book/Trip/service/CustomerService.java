package com.mbb.Book.Trip.service;

import com.mbb.Book.Trip.Enum.Gender;
import com.mbb.Book.Trip.exception.customerNotFound;
import com.mbb.Book.Trip.model.Booking;
import com.mbb.Book.Trip.model.Customer;
import com.mbb.Book.Trip.repository.CustomerRepository;
import com.mbb.Book.Trip.request.CustomerRequest;
import com.mbb.Book.Trip.response.CustomerResponse;
import com.mbb.Book.Trip.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository repo;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.customerToRequest(customerRequest);

        Customer savedCust = repo.save(customer);

        CustomerResponse response = CustomerTransformer.customerToCustomerResponse(savedCust);

        return response;


    }

    public CustomerResponse getById(int customerId) {
        Optional<Customer> optionalCust = repo.findById(customerId);
//        the method findById has return type is optional
        if (optionalCust.isEmpty()) {
            throw new customerNotFound("Invalid Input id");
        }
        Customer getCustomer = optionalCust.get();

        CustomerResponse response = CustomerTransformer.customerToCustomerResponse(getCustomer);

        return response;


    }

    public List<CustomerResponse> getByGenderandAge(Gender gender, int age) {
        List<Customer> customerList = repo.getByGenderAndAge(gender, age);
        List<CustomerResponse> responses = new ArrayList<>();
        for (Customer cust : customerList) {
            responses.add(CustomerTransformer.customerToCustomerResponse(cust));
        }
        return responses;
    }

    public List<CustomerResponse> getByGenderandAgeGreaterThan(Gender gender, int age) {

        List<Customer> customerList = repo.getByGenderAndAgeGreaterThan(gender, age);
        List<CustomerResponse> responses = new ArrayList<>();
        for (Customer cust : customerList) {
            responses.add(CustomerTransformer.customerToCustomerResponse(cust));
        }
        return responses;


    }

    public List<CustomerResponse> getByGenderandAgeGreaterThanUsingSQL(String gender, int age) {
        List<Customer> customerList = repo.getByGenderAndAgeGreaterThanUsingSQL(gender, age);
        List<CustomerResponse> responses = new ArrayList<>();
        for (Customer cust : customerList) {
            responses.add(CustomerTransformer.customerToCustomerResponse(cust));
        }
        return responses;


    }

    public List<CustomerResponse> getCustomerMoreThanTwoBookings(Date date) {
        List<CustomerResponse>listOfCustomer=new ArrayList<>();
        List<Customer> custList=repo.findAll();
        for(Customer cust:custList){
            List<Booking>books=cust.getBookings();
            int count=0;

            for(Booking book:books){
                Date dateTime=book.getBookedAt();
                LocalDate extractedDate = dateTime.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();

                LocalDate inputDate = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();



                if(extractedDate.isEqual(inputDate)){
                    count++;
                }
                if(count >= 2) {
                    listOfCustomer.add(CustomerTransformer.customerToCustomerResponse(cust));
                    break;
                }
            }

        }

        return listOfCustomer;
    }
}


