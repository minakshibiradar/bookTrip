package com.mbb.Book.Trip.service;

import com.mbb.Book.Trip.exception.DriverNotFoundException;
import com.mbb.Book.Trip.model.Booking;
import com.mbb.Book.Trip.model.Driver;
import com.mbb.Book.Trip.repository.BookingRepository;
import com.mbb.Book.Trip.repository.DriverRepository;
import com.mbb.Book.Trip.request.DriverRequest;
import com.mbb.Book.Trip.response.DriverFareByDate;
import com.mbb.Book.Trip.response.DriverResponse;
import com.mbb.Book.Trip.transformer.DriverTransformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository book;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver= DriverTransformer.driverRequestToDriver(driverRequest);
        driverRepository.save(driver);
        DriverResponse response=DriverTransformer.driverToDriverResponse(driver);

        return response;

    }



//    public list<Booking> driveBookingAndBill(int driverId, Date date){
//        Optional<Driver> driver=driverRepository.findById(driverId);
//        if(driver.isEmpty()){
//            throw new DriverNotFoundException("Drive is not valid");
//        }
//        Driver drive=driver.get();
//        List<Booking> bookingList=drive.getBookings();
//        List<Booking> bookingsByDate=book.getAllBookingsByDate();
//
//
//    }
}
