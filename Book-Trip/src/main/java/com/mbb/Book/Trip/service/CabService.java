package com.mbb.Book.Trip.service;


import com.mbb.Book.Trip.exception.DriverNotFoundException;
import com.mbb.Book.Trip.model.Cab;
import com.mbb.Book.Trip.model.Driver;
import com.mbb.Book.Trip.repository.CabRespository;
import com.mbb.Book.Trip.repository.DriverRepository;
import com.mbb.Book.Trip.request.CabRequest;
import com.mbb.Book.Trip.response.CabResponse;
import com.mbb.Book.Trip.response.DriverResponse;
import com.mbb.Book.Trip.transformer.CabTransformer;
import com.mbb.Book.Trip.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {
    @Autowired
    CabRespository cabRespository;

    @Autowired
    DriverRepository driverRepository;
    public CabResponse addCabWithDriver(CabRequest cabRequest, int driverId) {

        Optional<Driver> optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver Id");

        }
        Driver driver=optionalDriver.get();
        Cab cab= CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);

        Driver saved=driverRepository.save(driver); //save both the position cab and driver due to cascading
        CabResponse response=CabTransformer.cabToCabReponse(saved.getCab(), DriverTransformer.driverToDriverResponse(driver));

        return response;

    }
}
