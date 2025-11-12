package com.mbb.Book.Trip.controller;

import com.mbb.Book.Trip.request.DriverRequest;
import com.mbb.Book.Trip.response.DriverFareByDate;
import com.mbb.Book.Trip.response.DriverResponse;
import com.mbb.Book.Trip.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest){
        return driverService.addDriver(driverRequest);

    }

//    request para=driveId and Date
//    return total distance travel and total bill amount



}
