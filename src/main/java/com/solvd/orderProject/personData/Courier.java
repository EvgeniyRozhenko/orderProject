package com.solvd.orderProject.personData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Courier extends Person {
    private int salaryPercentPerShift;
    private String transportType;
    private int amountOfMaxOrdersForOneTime;

    private static final Logger LOGGER = LogManager.getLogger(Courier.class);

    public Courier(String name, String surname, int telephoneNumber, int salaryPercent, String transportType) {
        super(name, surname, telephoneNumber);
        this.salaryPercentPerShift = salaryPercent;
        this.transportType = transportType;
        this.amountOfMaxOrdersForOneTime = 3;
    }

    public int getSalaryPercent() {
        return salaryPercentPerShift;
    }

    public void setSalaryPercent(int salaryPercent) {
        this.salaryPercentPerShift = salaryPercent;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public int getAmountOfMaxOrdersForOneTime() {
        return amountOfMaxOrdersForOneTime;
    }

    public void setAmountOfMaxOrdersForOneTime(int amountOfMaxOrdersForOneTime) {
        this.amountOfMaxOrdersForOneTime = amountOfMaxOrdersForOneTime;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + '\n' +
                "salaryPercent: " + salaryPercentPerShift + '\n' +
                "transportType: " + transportType + '\n' +
                "amountOfMaxOrdersForOneTime: " + amountOfMaxOrdersForOneTime + '\n' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        if (!super.equals(o)) return false;
        Courier courier = (Courier) o;
        return salaryPercentPerShift == courier.salaryPercentPerShift
                && amountOfMaxOrdersForOneTime == courier.amountOfMaxOrdersForOneTime
                && transportType.equals(courier.transportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salaryPercentPerShift, transportType, amountOfMaxOrdersForOneTime);
    }

    @Override
    public void useCreditCard(CreditCard card, double amountOfTotalOrderCost) {
        double percentageOfAmount = amountOfTotalOrderCost / 100 * this.getSalaryPercent();
        card.setMoneyBalance(card.getMoneyBalance() + percentageOfAmount);
    }
}
