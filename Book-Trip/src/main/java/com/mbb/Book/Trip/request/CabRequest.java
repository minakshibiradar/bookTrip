package com.mbb.Book.Trip.request;

public class CabRequest {
    private String cabNumber;

    private String cabModel;

    private double perKm;

    public CabRequest() {
    }

    public CabRequest(String cabNumber, String cabModel, double perKm) {
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.perKm = perKm;
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
}
