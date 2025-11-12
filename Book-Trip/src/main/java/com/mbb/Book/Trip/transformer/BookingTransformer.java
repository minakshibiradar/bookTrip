package com.mbb.Book.Trip.transformer;

import com.mbb.Book.Trip.Enum.TripStatus;
import com.mbb.Book.Trip.model.Booking;
import com.mbb.Book.Trip.model.Cab;
import com.mbb.Book.Trip.model.Customer;
import com.mbb.Book.Trip.model.Driver;
import com.mbb.Book.Trip.request.BookingRequest;
import com.mbb.Book.Trip.response.BookingResponse;

public class BookingTransformer {

    public static Booking bookingRequstToBooking(BookingRequest bookRequest,double perKmRate){
        Booking booking=new Booking();
        booking.setPickup(bookRequest.getPickup());
        booking.setDestination(bookRequest.getDestination());
        booking.setTripDistanceInKm(bookRequest.getTripDistanceInKm());
        booking.setTripStatus(TripStatus.Ongoing);
        booking.setBillAmount(booking.getTripDistanceInKm()*perKmRate);
        return booking;
    }

    public static BookingResponse bookingToBookingResponse(Booking book, Customer cust, Cab cab,Driver driver) {
        BookingResponse bookingResponse=new BookingResponse();
        bookingResponse.setBookedAt(book.getBookedAt());
//
        bookingResponse.setBillAmount(book.getBillAmount());
        bookingResponse.setDestination(book.getDestination());
        bookingResponse.setPickup(book.getPickup());
        bookingResponse.setLastUpdateAt(book.getLastUpdateAt());
        bookingResponse.setTripDistanceInKm(book.getTripDistanceInKm());
        bookingResponse.setTripStatus(book.getTripStatus());
        bookingResponse.setCustomer(CustomerTransformer.customerToCustomerResponse(cust));
        bookingResponse.setCab(CabTransformer.cabToCabReponse(cab,DriverTransformer.driverToDriverResponse(driver)));


        return bookingResponse;
    }
}
