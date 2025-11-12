package com.mbb.Book.Trip.transformer;

import com.mbb.Book.Trip.model.Customer;
import com.mbb.Book.Trip.request.CustomerRequest;
import com.mbb.Book.Trip.response.CustomerResponse;
import lombok.Builder;

public class CustomerTransformer {

    public static Customer customerToRequest(CustomerRequest customerRequest){
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());
        return customer;
//        return Customer.builder()
//                .name(customerRequest.getName())
//                .age(customerRequest.getAge())
//                .emailId(customerRequest.getEmailId())
//                .gender(customerRequest.getGender())
//                .build();

    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        CustomerResponse response=new CustomerResponse();

        response.setAge(customer.getAge());
        response.setEmailId(customer.getEmailId());
        response.setName(customer.getName());
        return response;

//        return CustomerResponse.builder()
//                .age(customer.getAge())
//                .emailId(customer.getEmailId())
//                .name(customer.getName())
//                .build();
    }
}
