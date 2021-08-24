package com.solvd.orderProject.food;

import com.solvd.orderProject.displayInfo.DisplayInformation;

import java.util.HashMap;
import java.util.List;

public enum FoodRecipe implements DisplayInformation {
    MARGARITA (
            "Pizza Margarita",
            new HashMap<>(){
                {
                    put("Flour", new Ingredient("Flour", 0.3, FoodService.getIngredientCostPerKGFromList("Flour")));
                    put("Tomato", new Ingredient("Tomato", 0.15, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Cheese", new Ingredient("Cheese", 0.2, FoodService.getIngredientCostPerKGFromList("Cheese")));
                    put("Basil", new Ingredient("Basil", 0.015, FoodService.getIngredientCostPerKGFromList("Basil")));
                }
            }),
    HAWAIIAN (
            "Hawaiian Pizza",
            new HashMap<>(){
                {
                    put("Flour", new Ingredient("Flour", 0.3, FoodService.getIngredientCostPerKGFromList("Flour")));
                    put("Tomato", new Ingredient("Tomato", 0.1, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Pepper", new Ingredient("Pepper", 0.05, FoodService.getIngredientCostPerKGFromList("Pepper")));
                    put("Chicken", new Ingredient("Chicken", 0.2, FoodService.getIngredientCostPerKGFromList("Chicken")));
                    put("Onion", new Ingredient("Onion", 0.05, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Pineapple", new Ingredient("Pineapple", 0.05, FoodService.getIngredientCostPerKGFromList("Pineapple")));
                }
            }),
    SALAMI (
            "Pizza Salami",
            new HashMap<>(){
                {
                    put("Flour", new Ingredient("Flour", 0.3, FoodService.getIngredientCostPerKGFromList("Flour")));
                    put("Tomato", new Ingredient("Tomato", 0.15, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Cheese", new Ingredient("Cheese", 0.2, FoodService.getIngredientCostPerKGFromList("Cheese")));
                    put("Basil", new Ingredient("Basil", 0.015, FoodService.getIngredientCostPerKGFromList("Basil")));
                }
            }),
    BURGER (
            "Burger",
            new HashMap<>(){
                {
                    put("Burger bread", new Ingredient("Burger bread",0.06, FoodService.getIngredientCostPerKGFromList("Burger bread")));
                    put("Tomato", new Ingredient("Tomato",0.02, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Onion", new Ingredient("Onion", 0.01, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Ground beef", new Ingredient("Ground beef", 0.08, FoodService.getIngredientCostPerKGFromList("Ground beef")));
                }
            }),
    CHEESE_BURGER (
            "Cheeseburger",
            new HashMap<>(){
                {
                    put("Burger bread", new Ingredient("Burger bread", 0.06, FoodService.getIngredientCostPerKGFromList("Burger bread")));
                    put("Tomato", new Ingredient("Tomato", 0.02, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Onion", new Ingredient("Onion", 0.01, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Ground beef", new Ingredient("Ground beef", 0.08, FoodService.getIngredientCostPerKGFromList("Ground beef")));
                    put("Cheese", new Ingredient("Cheese", 0.03, FoodService.getIngredientCostPerKGFromList("Cheese")));
                }
            }),
    FRENCH_FRIES (
            "French Fries",
            new HashMap<>(){
                {
                    put("Potato", new Ingredient("Potato", 0.08, FoodService.getIngredientCostPerKGFromList("Potato")));
                }
            }),
    NUGGETS (
            "Nuggets",
            new HashMap<>(){
                {
                    put("Chicken", new Ingredient("Chicken", 0.2, FoodService.getIngredientCostPerKGFromList("Chicken")));
                    put("Flour", new Ingredient("Flour", 0.02, FoodService.getIngredientCostPerKGFromList("Flour")));
                }
            }),
    CHICKEN_BURGER (
            "Chickenburger",
            new HashMap<>(){
                {
                    put("Burger bread", new Ingredient("Burger bread", 0.06, FoodService.getIngredientCostPerKGFromList("Burger bread")));
                    put("Tomato", new Ingredient("Tomato", 0.02, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Onion", new Ingredient("Onion", 0.01, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Chicken", new Ingredient("Chicken", 0.08, FoodService.getIngredientCostPerKGFromList("Chicken")));
                    put("Cheese", new Ingredient("Cheese", 0.03, FoodService.getIngredientCostPerKGFromList("Cheese")));
                }
            }),
    PORK_RIBS (
            "Pork ribs",
            new HashMap<>(){
                {
                    put("Pork ribs", new Ingredient("Pork ribs", 0.3, FoodService.getIngredientCostPerKGFromList("Pork ribs")));
                    put("Potato", new Ingredient("Potato", 0.1, FoodService.getIngredientCostPerKGFromList("Potato")));
                    put("Onion", new Ingredient("Onion", 0.04, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Mushrooms", new Ingredient("Mushrooms", 0.08, FoodService.getIngredientCostPerKGFromList("Mushrooms")));
                }
            }),
    SHASHLIK (
            "Shashlik",
            new HashMap<>(){
                {
                    put("Pork meat", new Ingredient("Pork meat", 0.25, FoodService.getIngredientCostPerKGFromList("Pork meat")));
                    put("Tomato", new Ingredient("Tomato",0.08, FoodService.getIngredientCostPerKGFromList("Tomato")));
                    put("Onion", new Ingredient("Onion", 0.06, FoodService.getIngredientCostPerKGFromList("Onion")));
                    put("Basil", new Ingredient("Basil", 0.05, FoodService.getIngredientCostPerKGFromList("Basil")));
                }
            }),
    NEW_YORK_STAKE ("NY Stake", new HashMap<>(){{put("Beef meat", new Ingredient("Beef meat", 0.35, FoodService.getIngredientCostPerKGFromList("Beef meat")));}});

    private final String name;
    private final HashMap<String, Ingredient> neededIngredients;
    private final double totalCookedWeight;
    private double totalCookedCost;

    FoodRecipe(String name, HashMap<String, Ingredient> neededIngredients) {
        this.name = name;
        this.neededIngredients = neededIngredients;

        double totalWeight = FoodService.calculateTotalWeight(this.neededIngredients);
        this.totalCookedWeight = totalWeight - (totalWeight * 0.1);

        double totalCost = FoodService.calculateTotalCost(this.neededIngredients);
        this.totalCookedCost = totalCost + (totalCookedCost * 0.2);
    }

    public String getName() {
        return name;
    }



    public HashMap<String, Ingredient> getNeededIngredients() {
        return neededIngredients;
    }

    public double getTotalCookedWeight() {
        return totalCookedWeight;
    }

    public double getTotalCookedCost() {
        return totalCookedCost;
    }

    public void setTotalCookedCost(double totalCookedCost) {
        this.totalCookedCost = totalCookedCost;
    }

    @Override
    public String showItemInformation() {
        return (this.ordinal() + 1) + "." + this.name;
    }
}
