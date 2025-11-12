package com.mbb.Book.Trip.model;


import com.mbb.Book.Trip.Enum.TripStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    to generate primary key no neeed to define by user
     int bookingId;

     String pickup;

     String destination;

     double tripDistanceInKm;

    TripStatus tripStatus;

    double billAmount;

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdateAt;

    public Booking() {
    }

    public Booking(int bookingId, String pickup, String destination, double tripDistanceInKm, TripStatus tripStatus, double billAmount, Date bookedAt, Date lastUpdateAt) {
        this.bookingId = bookingId;
        this.pickup = pickup;
        this.destination = destination;
        this.tripDistanceInKm = tripDistanceInKm;
        this.tripStatus = tripStatus;
        this.billAmount = billAmount;
        this.bookedAt = bookedAt;
        this.lastUpdateAt = lastUpdateAt;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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
}
