package com.mbb.Book.Trip.transformer;

import com.mbb.Book.Trip.model.Cab;
import com.mbb.Book.Trip.request.CabRequest;
import com.mbb.Book.Trip.response.CabResponse;
import com.mbb.Book.Trip.response.DriverResponse;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        Cab cab=new Cab();
        cab.setCabModel(cabRequest.getCabModel());
        cab.setCabNumber(cabRequest.getCabNumber());
        cab.setAvailable(true);
        cab.setPerKm(cabRequest.getPerKm());
        return cab;

    }

    public static CabResponse cabToCabReponse(Cab cab, DriverResponse driverResponse){
        CabResponse cabResponse=new CabResponse();
        cabResponse.setAvailable(cab.isAvailable());
        cabResponse.setCabModel(cab.getCabModel());
        cabResponse.setCabNumber(cab.getCabNumber());
        cabResponse.setPerKm(cab.getPerKm());
        cabResponse.setDriverResponse(driverResponse);
        return cabResponse;
    }
}
