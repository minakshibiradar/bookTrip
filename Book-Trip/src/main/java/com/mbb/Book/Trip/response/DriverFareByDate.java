package com.mbb.Book.Trip.response;

public class DriverFareByDate {
    private long totalDistance;
    private Double totalFare;

    public DriverFareByDate() {
    }

    public DriverFareByDate(long totalDistance, Double totalFare) {
        this.totalDistance = totalDistance;
        this.totalFare = totalFare;
    }
}
