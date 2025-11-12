package com.mbb.Book.Trip.repository;

import com.mbb.Book.Trip.Enum.Gender;
import com.mbb.Book.Trip.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    List<Customer> getByGenderAndAge(Gender gender, int age);


    @Query("select c from Customer c where c.gender = :gender and c.age > :age") //HQl-Hierbrnate Query language
    List<Customer> getByGenderAndAgeGreaterThan(@Param("gender")Gender gender,
                                                @Param("age") int age);


    @Query(value = "select * from customer where gender=:gender and age > :age",nativeQuery = true) //SQL
    List<Customer> getByGenderAndAgeGreaterThanUsingSQL(String gender, int age);


    @Query("Select c from Customer c join booking , COUNT(booking) > 2 where booking.bookedAt=:date Group by booking.bookedAt")
    List<Customer> getCustomerMorethanTwoBooking(@Param("date") Date date);
//    here we take gender as a string because gender is enum in Customer class but in customer table it
//    is a varchar , SQL do not have enum datatype . When you using SQl keep this is in mind;
}
