package com.solvd.orderProject.order;

import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.food.Ingredient;

import java.util.List;

public interface IPriceCalculating {

    double calculateTotalCostOfFood(List<Ingredient> ingredients);
    double calculateTotalCostOfBeverage(List<Beverage> beverageOrder);
    double calculateTotalCostOfWholeOrder(double totalCostOfFood, double totalCostOfBeverage, double logisticCost);
}
