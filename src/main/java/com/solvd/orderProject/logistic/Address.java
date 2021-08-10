package com.solvd.orderProject.logistic;

import java.util.Arrays;
import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private String building;
    private double[] coordinatesXY;

    public Address(String city, String street, String building, double[] coordinatesXY) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.coordinatesXY = coordinatesXY;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public double[] getCoordinatesXY() {
        return coordinatesXY;
    }

    public void setCoordinatesXY(double[] coordinatesXY) {
        this.coordinatesXY = coordinatesXY;
    }

    @Override
    public String toString() {
        return "Address {" +
                "city '" + city + '\'' +
                ", street '" + street + '\'' +
                ", building '" + building + '\'' +
                ", coordinatesXY " + Arrays.toString(coordinatesXY) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return city.equals(address.city) && street.equals(address.street) && building.equals(address.building) && Arrays.equals(coordinatesXY, address.coordinatesXY);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(city, street, building);
        result = 31 * result + Arrays.hashCode(coordinatesXY);
        return result;
    }
}
