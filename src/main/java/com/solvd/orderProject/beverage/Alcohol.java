package com.solvd.orderProject.beverage;

import com.solvd.orderProject.util.AlcoholVolumeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Alcohol extends Beverage {
    private double alcoPercentOfValume;

    private static final Logger LOGGER = LogManager.getLogger(Alcohol.class);

    public Alcohol(String name, double volumeOfBottle, String taste, double costPerBottle, double alcoPercentOfValume) {
        super(name, volumeOfBottle, taste, costPerBottle);
            if (alcoPercentOfValume > 40) throw new AlcoholVolumeException("Volume of alcohol cannot be more then 40%");
            this.alcoPercentOfValume = alcoPercentOfValume;
    }

    public double getAlcoPercentOfValume() {
        return alcoPercentOfValume;
    }

    public void setAlcoPercentOfValume(double alcoPercentOfValume) {
            if (alcoPercentOfValume > 40) throw new AlcoholVolumeException("Volume of alcohol cannot be more then 40%");
            this.alcoPercentOfValume = alcoPercentOfValume;
    }

    @Override
    public String toString() {
        return "Alcohol {" +
                "alcoPercentOfValume " + alcoPercentOfValume +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alcohol)) return false;
        if (!super.equals(o)) return false;
        Alcohol alcohol = (Alcohol) o;
        return alcoPercentOfValume == alcohol.alcoPercentOfValume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alcoPercentOfValume);
    }

    @Override
    public void relieveTension() {
        LOGGER.info("I can dance whole night long!");
    }
}