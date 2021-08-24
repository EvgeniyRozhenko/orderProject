package com.solvd.orderProject.beverage;

import com.solvd.orderProject.util.ZeroSizeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Juice extends Beverage {
    private char[] vitamin;
    private String pulpLevel;

    private static final Logger LOGGER = LogManager.getLogger(Juice.class);

    public Juice(Integer id, String name, double volumeOfBottle, String taste, double costPerBottle, char[] vitamin, String pulpLevel) {
        super(id, name, volumeOfBottle, taste, costPerBottle);
        if (vitamin.length == 0)
            throw new ZeroSizeException("Zero length of char array parameter.");
        this.vitamin = vitamin;
        this.pulpLevel = pulpLevel;
    }

    public char[] getVitamin() {
        return vitamin;
    }

    public void setVitamin(char[] vitamin) {
        if (vitamin.length == 0)
            throw new ZeroSizeException("Zero length of char array parameter.");
        this.vitamin = vitamin;
    }

    public String getPulpLevel() {
        return pulpLevel;
    }

    public void setPulpLevel(String pulpLevel) {
        this.pulpLevel = pulpLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("Beverage", "Juice")
                .replace("};", ",")
                + "vitamin " + Arrays.toString(vitamin)
                + ", pulpLevel '" + pulpLevel + "' }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juice)) return false;
        if (!super.equals(o)) return false;
        Juice juice = (Juice) o;
        return Arrays.equals(vitamin, juice.vitamin) && pulpLevel.equals(juice.pulpLevel);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), pulpLevel);
        result = 31 * result + Arrays.hashCode(vitamin);
        return result;
    }

    @Override
    public void relieveTension() {
        LOGGER.info("Yummy-yummy! I'm not afraid of Corona at all!");
    }
}

