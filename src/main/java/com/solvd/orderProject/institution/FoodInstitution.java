package com.solvd.orderProject.institution;

import com.solvd.orderProject.logistic.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class FoodInstitution {
    private int id;
    private String name;
    private Address address;
    private TypeOfInstitution typeOfFoodInstitution;
    private Menu menu;
    private String serviceQuality;

    private static final Logger LOGGER = LogManager.getLogger(FoodInstitution.class);

    public FoodInstitution() {}

    public FoodInstitution(int id, String name, Address address, TypeOfInstitution typeOfFoodInstitution) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.typeOfFoodInstitution = typeOfFoodInstitution;
        this.menu = new Menu(this.typeOfFoodInstitution);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TypeOfInstitution getTypeOfFoodInstitution() {
        return typeOfFoodInstitution;
    }

    public void setTypeOfFoodInstitution(TypeOfInstitution typeOfFoodInstitution) {
        this.typeOfFoodInstitution = typeOfFoodInstitution;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getServiceQuality() {
        return serviceQuality;
    }

    public void setServiceQuality(String serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodInstitution)) return false;
        FoodInstitution that = (FoodInstitution) o;
        return id == that.id && name.equals(that.name) && address.equals(that.address)
                && typeOfFoodInstitution == that.typeOfFoodInstitution && menu.equals(that.menu)
                && serviceQuality.equals(that.serviceQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, typeOfFoodInstitution, menu, serviceQuality);
    }

    @Override
    public String toString() {
        return "FoodInstitution \n { " +
                "name: " + '\"' + name.toUpperCase() + '\"' +
                "; address: '" + address + '\'' +
                "; typeOfFoodInstitution: " + typeOfFoodInstitution +
                ";" + menu +
                "; serviceQuality: " + serviceQuality + " " +
                '}' + '\n';
    }
}
