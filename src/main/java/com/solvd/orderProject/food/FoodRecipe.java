package com.solvd.orderProject.food;

import java.util.HashSet;
import java.util.Set;

public enum FoodRecipe {
    MARGARITA ("Pizza Margarita", new HashSet<>()),
    HAWAIIAN ("Hawaiian Pizza", new HashSet<>()),
    SALAMI ("Pizza Salami", new HashSet<>()),
    BURGER ("Burger", new HashSet<>()),
    CHEESE_BURGER ("Cheeseburger", new HashSet<>()),
    FRENCH_FRIES ("French Fries", new HashSet<>()),
    NUGGETS ("Nuggets", new HashSet<>()),
    CHICKEN_BURGER ("Chickenburger", new HashSet<>()),
    PORK_RIBS ("Pork ribs", new HashSet<>()),
    SHASHLIK ("Shashlik", new HashSet<>()),
    NEW_YORK_STAKE ("NY Stake", new HashSet<>());

    private final String name;
    private Set<Ingredient> neededIngredients;
    private double totalCookedWeight;
    private double totalCookedCost;

    FoodRecipe(String name, Set<Ingredient> neededIngredients) {
        this.name = name;
        this.neededIngredients = neededIngredients;
        double totalCookedWeight = 0;
        for (Ingredient value : neededIngredients) {
            totalCookedWeight += value.getWeight();
        }
        totalCookedWeight = totalCookedWeight - (totalCookedWeight * 0.1);
        this.totalCookedWeight = totalCookedWeight;
        double totalCookedCost = 0;
        for (Ingredient value : neededIngredients) {
            totalCookedCost += value.calculateIngredientCost(value.getCostPerKG(), value.getWeight());
        }
        totalCookedCost = totalCookedCost + (totalCookedCost * 0.2);
        this.totalCookedCost = totalCookedCost;
    }

    public String getName() {
        return name;
    }

    public Set<Ingredient> getNeededIngredients() {
        return neededIngredients;
    }

    public void setNeededIngredients(Set<Ingredient> neededIngredients) {
        this.neededIngredients = neededIngredients;
    }

    public double getTotalCookedWeight() {
        return totalCookedWeight;
    }

    public void setTotalCookedWeight(double totalCookedWeight) {
        this.totalCookedWeight = totalCookedWeight;
    }

    public double getTotalCookedCost() {
        return totalCookedCost;
    }

    public void setTotalCookedCost(double totalCookedCost) {
        this.totalCookedCost = totalCookedCost;
    }
}
