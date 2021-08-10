package com.solvd.orderProject.logistic;

import com.solvd.orderProject.util.XYCoordinateFormatException;

import java.util.Objects;

public class Logistic implements ICalculatingDistance {
    private Address shippingAddress;
    private Address deliveringAddress;
    private boolean isPayableService;
    private double distance;

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getDeliveringAddress() {
        return deliveringAddress;
    }

    public void setDeliveringAddress(Address deliveringAddress) {
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
        return isPayableService == logistic.isPayableService && Double.compare(logistic.distance, distance) == 0
                && shippingAddress.equals(logistic.shippingAddress) && deliveringAddress.equals(logistic.deliveringAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingAddress, deliveringAddress, isPayableService, distance);
    }

    @Override
    public double countDistanceValue(double[] pointXY1, double[] pointXY2) {
        if (pointXY1.length > 2 && pointXY2.length > 2) {
            throw new XYCoordinateFormatException("Check format of XY coordinate");
        }
        double sumPowPoint1 = Math.pow(pointXY1[0] - pointXY2[0], 2);
        double sumPowPoint2 = Math.pow(pointXY1[1] - pointXY2[1], 2);
        return Math.abs(Math.sqrt(sumPowPoint1 + sumPowPoint2));
    }

    @Override
    public double countDistanceCost(boolean isPayableService, double distanceValue, double costPerKilometer) {
        return isPayableService ? distanceValue * costPerKilometer : 0;
    }
}
