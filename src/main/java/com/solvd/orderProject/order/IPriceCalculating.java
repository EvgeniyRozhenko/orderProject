package com.solvd.orderProject.order;

public interface IPriceCalculating {

    double calculateTotalCostOfWholeOrder(double totalCostOfFood, double totalCostOfBeverage, double logisticCost);
}
