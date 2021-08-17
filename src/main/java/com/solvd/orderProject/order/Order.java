package com.solvd.orderProject.order;

import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.food.FoodRecipe;
import com.solvd.orderProject.institution.Menu;
import com.solvd.orderProject.util.ZeroSizeException;
import com.solvd.orderProject.food.Ingredient;

import java.util.List;
import java.util.Objects;

public class Order implements IPriceCalculating {
    private int numberOfOrder;
    private String institutionName;
    private String clientName;
    private List<FoodRecipe> foodOrder;
    private int totalQuantityOfOrderedFood;
    private List<Beverage> beverageOrder;
    private int getTotalQuantityOfOrderedBeverage;
    private String operatorName;
    private String courierName;
    private double distance;
    private double logisticCost;
    private double totalOrderPayment;

    public Order() {}

    public Order(int numberOfOrder, String institutionName, String clientName, List<FoodRecipe> foodOrder,
                 int totalQuantityOfOrderedFood, List<Beverage> beverageOrder, int getTotalQuantityOfOrderedBeverage,
                 String operatorName, String courierName, double distance, double logisticCost, double totalOrderPayment) {
        if (foodOrder.size() == 0 || beverageOrder.size() == 0)
            throw new ZeroSizeException("Zero size of collection parameter.");
        this.numberOfOrder = numberOfOrder;
        this.institutionName = institutionName;
        this.clientName = clientName;
        this.foodOrder = foodOrder;
        this.totalQuantityOfOrderedFood = totalQuantityOfOrderedFood;
        this.beverageOrder = beverageOrder;
        this.getTotalQuantityOfOrderedBeverage = getTotalQuantityOfOrderedBeverage;
        this.operatorName = operatorName;
        this.courierName = courierName;
        this.distance = distance;
        this.logisticCost = logisticCost;
        this.totalOrderPayment = totalOrderPayment;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<FoodRecipe> getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(List<FoodRecipe> foodOrder) {
        if (foodOrder.size() == 0)
            throw new ZeroSizeException("Zero size of parameter.");
        this.foodOrder = foodOrder;
    }

    public int getTotalQuantityOfOrderedFood() {
        return totalQuantityOfOrderedFood;
    }

    public void setTotalQuantityOfOrderedFood(int totalQuantityOfOrderedFood) {
        this.totalQuantityOfOrderedFood = totalQuantityOfOrderedFood;
    }

    public List<Beverage> getBeverageOrder() {
        return beverageOrder;
    }

    public void setBeverageOrder(List<Beverage> beverageOrder) {
        if (beverageOrder.size() == 0)
            throw new ZeroSizeException("Zero size of parameter.");
        this.beverageOrder = beverageOrder;
    }

    public int getGetTotalQuantityOfOrderedBeverage() {
        return getTotalQuantityOfOrderedBeverage;
    }

    public void setGetTotalQuantityOfOrderedBeverage(int getTotalQuantityOfOrderedBeverage) {
        this.getTotalQuantityOfOrderedBeverage = getTotalQuantityOfOrderedBeverage;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLogisticCost() {
        return logisticCost;
    }

    public void setLogisticCost(double logisticCost) {
        this.logisticCost = logisticCost;
    }

    public double getTotalOrderPayment() {
        return totalOrderPayment;
    }

    public void setTotalOrderPayment(double totalCostOfWholeOrder) {
        this.totalOrderPayment = totalCostOfWholeOrder;
    }

    @Override
    public String toString() {
        return "__Order__" + '\n' +
                "{ numberOfOrder: " + numberOfOrder + '\n' +
                " institutionData: " + institutionName + '\n' +
                " clientData: " + clientName + '\n' +
                " foodOrder: " + foodOrder + '\n' +
                " totalQuantityOfOrderedFood: " + totalQuantityOfOrderedFood + '\n' +
                " beverageOrder: " + beverageOrder + '\n' +
                " getTotalQuantityOfOrderedBeverage: " + getTotalQuantityOfOrderedBeverage + '\n' +
                " operatorData: " + operatorName + '\n' +
                " courierData: " + courierName + '\n' +
                " distance: " + distance + '\n' +
                " logisticCost: " + logisticCost + '\n' +
                " totalOrderPayment: " + totalOrderPayment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return numberOfOrder == order.numberOfOrder && totalQuantityOfOrderedFood == order.totalQuantityOfOrderedFood
                && getTotalQuantityOfOrderedBeverage == order.getTotalQuantityOfOrderedBeverage
                && Double.compare(order.distance, distance) == 0 && Double.compare(order.logisticCost, logisticCost) == 0
                && Double.compare(order.totalOrderPayment, totalOrderPayment) == 0 && institutionName.equals(order.institutionName)
                && clientName.equals(order.clientName) && foodOrder.equals(order.foodOrder) && beverageOrder.equals(order.beverageOrder)
                && operatorName.equals(order.operatorName) && courierName.equals(order.courierName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfOrder, institutionName, clientName, foodOrder, totalQuantityOfOrderedFood,
                beverageOrder, getTotalQuantityOfOrderedBeverage, operatorName, courierName, distance,
                logisticCost, totalOrderPayment);
    }

    @Override
    public double calculateTotalCostOfWholeOrder(double totalCostOfFood, double totalCostOfBeverage, double logisticCost) {
        return totalCostOfFood + totalCostOfBeverage +  logisticCost;
    }
}
