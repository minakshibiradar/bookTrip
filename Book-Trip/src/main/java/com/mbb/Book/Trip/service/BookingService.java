package com.mbb.Book.Trip.service;

import com.mbb.Book.Trip.exception.CabNotFoundException;
import com.mbb.Book.Trip.exception.customerNotFound;
import com.mbb.Book.Trip.model.Booking;
import com.mbb.Book.Trip.model.Cab;
import com.mbb.Book.Trip.model.Customer;
import com.mbb.Book.Trip.model.Driver;
import com.mbb.Book.Trip.repository.BookingRepository;

import com.mbb.Book.Trip.repository.CabRespository;
import com.mbb.Book.Trip.repository.CustomerRepository;
import com.mbb.Book.Trip.repository.DriverRepository;
import com.mbb.Book.Trip.request.BookingRequest;
import com.mbb.Book.Trip.response.BookingResponse;
import com.mbb.Book.Trip.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRespository cabRespository;

    @Autowired
    JavaMailSender javaEmailSender;

//    public BookingResponse addBookingOfCustomer(BookingRequest bookingRequest, int customer) {
//        Optional<Customer> customer1=customerRepository.findById(customer);
//        if(customer1.isEmpty()){
//            throw new customerNotFound(" Customer Not Found");
//        }
//        Customer cust=customer1.get();
//        Booking book=BookingTransformer.bookingRequstToBooking(bookingRequest);
//        List<Booking>bookings=cust.getBookings();
//        bookings.add(book);
//        cust.setBookings(bookings);
//        customerRepository.save(cust);
//        bookingRepository.save(book);
//        List<Driver>drivers=driverRepository.findAll();
//        int index=(int)(Math.random()* drivers.size());
//        Driver driver=drivers.get(index);
//        BookingResponse bookingResponse=BookingTransformer.bookingToBookingResponse(book,driver);
//        return bookingResponse;
//
//    }

    public BookingResponse addBookingOfCustomer(BookingRequest bookingRequest, int customer) {
        Optional<Customer> customer1 = customerRepository.findById(customer);
        if (customer1.isEmpty()) {
            throw new customerNotFound(" Customer Not Found");
        }
        Customer cust = customer1.get();
        Cab availableCab = cabRespository.getAvailableCabRandom();
        if (availableCab == null) {
            throw new CabNotFoundException("Sorry! cab not there");
        }

        Booking booking = BookingTransformer.bookingRequstToBooking(bookingRequest, availableCab.getPerKm());
        Booking savedBooking = bookingRepository.save(booking);
        availableCab.setAvailable(false);
        cust.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(cust);
        Driver savedDriver = driverRepository.save(driver);

        sendEmail(savedCustomer);


        return BookingTransformer.bookingToBookingResponse(savedBooking, savedCustomer, availableCab, savedDriver);

    }

    private void sendEmail(Customer customer){
        String message="Congratulations!"+"\n"+ customer.getName()+"\n"+"Your Cab Is Booking.";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("mbbdeveloper666@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("Cab Booked");
        simpleMailMessage.setText(message);

        javaEmailSender.send(simpleMailMessage);
    }
}
