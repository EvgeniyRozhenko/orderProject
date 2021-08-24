package com.solvd.orderProject.beverage;

import com.solvd.orderProject.displayInfo.DisplayInformation;
import com.solvd.orderProject.order.MenuItem;
import com.solvd.orderProject.util.VolumeOfBottleException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class Beverage extends MenuItem implements IRefreshing, DisplayInformation {
    private String name;
    private double volumeOfBottle;
    private String taste;
    private double costPerBottle;

    public Beverage(Integer id, String name, double volumeOfBottle, String taste, double costPerBottle) {
        if (!(volumeOfBottle == 0.33 || volumeOfBottle == 0.5 || volumeOfBottle == 0.7 || volumeOfBottle == 1))
            throw new VolumeOfBottleException("Not correct standard volume of bottle. Set 0.33, 0.5, 0.7 or 1 volume.");

        this.name = name;
        this.volumeOfBottle = volumeOfBottle;
        this.taste = taste;
        this.costPerBottle = costPerBottle;
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolumeOfBottle() {
        return volumeOfBottle;
    }

    public void setVolumeOfBottle(double volumeOfBottle) {
        if (volumeOfBottle != 0.33 || volumeOfBottle != 0.5 || volumeOfBottle != 1.0)
            throw new VolumeOfBottleException("Not correct standard volume of bottle. Set 0.33, 0.5 or 1.0 volume.");

        this.volumeOfBottle = volumeOfBottle;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public double getCostPerBottle() {
        return costPerBottle;
    }

    public void setCostPerBottle(double costPerBottle) {
        this.costPerBottle = costPerBottle;
    }

    @Override
    public String toString() {
        return "Beverage { \"" + name + "\", vol. " + volumeOfBottle
                + ", '" + taste + "', cost " + costPerBottle + " }; ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage)) return false;
        if (!super.equals(o)) return false;
        Beverage beverage = (Beverage) o;
        return Double.compare(beverage.volumeOfBottle, volumeOfBottle) == 0
                && Double.compare(beverage.costPerBottle, costPerBottle) == 0
                && name.equals(beverage.name) && taste.equals(beverage.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, volumeOfBottle, taste, costPerBottle);
    }

    public abstract void relieveTension();

    public static double countBeverageTotalCost(List<Beverage> beverages) {
        double totalCost = 0;
        for (Beverage item : beverages) {
            totalCost += item.costPerBottle;
        }
        return totalCost;
    }

    public static double countBeverageTotalVolume(HashSet<Beverage> beverages) {
        double totalVolume = 0;
        for (Beverage item : beverages) {
            totalVolume += item.volumeOfBottle;
        }
        return totalVolume;
    }

    @Override
    public String showItemInformation() {
        return super.getId() + "." + name + " (" + volumeOfBottle + " vol.)";
    }
}
