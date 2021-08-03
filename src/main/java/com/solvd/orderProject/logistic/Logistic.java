package com.solvd.orderProject.logistic;

import java.util.Objects;

public class Logistic implements ICalculatingDistance {
    private String shippingAddress;
    private String deliveringAddress;
    private boolean isPayableService;
    private double distance;

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getDeliveringAddress() {
        return deliveringAddress;
    }

    public void setDeliveringAddress(String deliveringAddress) {
        this.deliveringAddress = deliveringAddress;
    }

    public boolean getPayableService() {
        return isPayableService;
    }

    public void setPayableService(boolean payableService) {
        isPayableService = payableService;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Logistic {" +
                "shippingAddress '" + shippingAddress + '\'' +
                ", deliveringAddress '" + deliveringAddress + '\'' +
                ", isPayableService " + isPayableService +
                ", distance " + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logistic)) return false;
        Logistic logistic = (Logistic) o;
        return isPayableService == logistic.isPayableService && Double.compare(logistic.distance, distance) == 0 && shippingAddress.equals(logistic.shippingAddress) && deliveringAddress.equals(logistic.deliveringAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingAddress, deliveringAddress, isPayableService, distance);
    }

    @Override
    public double countDistanceCost(double distanceValue, boolean isPayableService, double costPerKilometer) {
        if (isPayableService) {
            return distanceValue * costPerKilometer;
        } else {
            return 0;
        }
    }
}
