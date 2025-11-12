package com.mbb.Book.Trip.response;

public class CabResponse {

    private String cabNumber;

    private String cabModel;

    private double perKm;

    private boolean available;

    private DriverResponse driverResponse;

    public CabResponse() {
    }

    public CabResponse(String cabNumber, String cabModel, double perKm, boolean available, DriverResponse driverResponse) {
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.perKm = perKm;
        this.available = available;
        this.driverResponse = driverResponse;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    public double getPerKm() {
        return perKm;
    }

    public void setPerKm(double perKm) {
        this.perKm = perKm;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public DriverResponse getDriverResponse() {
        return driverResponse;
    }

    public void setDriverResponse(DriverResponse driverResponse) {
        this.driverResponse = driverResponse;
    }
}
