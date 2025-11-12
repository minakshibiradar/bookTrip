package com.mbb.Book.Trip.response;

import com.mbb.Book.Trip.Enum.TripStatus;
import com.mbb.Book.Trip.model.Cab;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    String pickup;

    String destination;

    double tripDistanceInKm;

    TripStatus tripStatus;

    double billAmount;


    Date bookedAt;


    Date lastUpdateAt;

    CabResponse cab;

    CustomerResponse customer;

    public BookingResponse() {
    }

    public BookingResponse(String pickup, String destination, double tripDistanceInKm, TripStatus tripStatus, double billAmount, Date bookedAt, Date lastUpdateAt) {
        this.pickup = pickup;
        this.destination = destination;
        this.tripDistanceInKm = tripDistanceInKm;
        this.tripStatus = tripStatus;
        this.billAmount = billAmount;
        this.bookedAt = bookedAt;
        this.lastUpdateAt = lastUpdateAt;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripDistanceInKm() {
        return tripDistanceInKm;
    }

    public void setTripDistanceInKm(double tripDistanceInKm) {
        this.tripDistanceInKm = tripDistanceInKm;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public CabResponse getCab() {
        return cab;
    }

    public void setCab(CabResponse cab) {
        this.cab = cab;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }
}
