package com.mbb.Book.Trip.controller;


import com.mbb.Book.Trip.request.CabRequest;
import com.mbb.Book.Trip.response.CabResponse;
import com.mbb.Book.Trip.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cab")
public class CabController {
    @Autowired
    CabService cabService;

    @PostMapping("/register/driver/{driverId}")
    public CabResponse addCadWithDriver(@RequestBody CabRequest cabRequest , @PathVariable("driverId") int driverId){
        return cabService.addCabWithDriver(cabRequest,driverId);
    }

}
