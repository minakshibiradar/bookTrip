package com.mbb.Book.Trip.transformer;

import com.mbb.Book.Trip.model.Driver;
import com.mbb.Book.Trip.request.DriverRequest;
import com.mbb.Book.Trip.response.DriverResponse;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        Driver driver=new Driver();
        driver.setAge(driverRequest.getAge());
        driver.setName(driverRequest.getName());
        driver.setEmailId(driverRequest.getEmailId());
        return driver;
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        DriverResponse driverResponse=new DriverResponse();
        driverResponse.setDriverId(driver.getDriverId());
        driverResponse.setAge(driver.getAge());
        driverResponse.setName(driver.getName());
        driverResponse.setEmailId(driver.getEmailId());
        return  driverResponse;
    }
}
