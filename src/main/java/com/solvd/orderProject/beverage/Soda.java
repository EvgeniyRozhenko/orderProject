package com.solvd.orderProject.beverage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Soda extends Beverage {
    private String sparklingLevel;

    private static final Logger LOGGER = LogManager.getLogger(Soda.class);

    public Soda(String name, double volumeOfBottle, String taste, double costPerBottle, String sparklingLevel) {
        super(name, volumeOfBottle, taste, costPerBottle);
        this.sparklingLevel = sparklingLevel;
    }

    public String getSparklingLevel() {
        return sparklingLevel;
    }

    public void setSparklingLevel(String sparklingLevel) {
        this.sparklingLevel = sparklingLevel;
    }

    @Override
    public String toString() {
        return "Soda {" +
                "sparklingLevel '" + sparklingLevel + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soda)) return false;
        if (!super.equals(o)) return false;
        Soda soda = (Soda) o;
        return sparklingLevel.equals(soda.sparklingLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sparklingLevel);
    }

    @Override
    public void relieveTension() {
        LOGGER.info("Too much sugar and burps for today...");
    }
}

