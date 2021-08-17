package com.solvd.orderProject.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FoodService {
    private static HashMap<String, Ingredient> ingredientsList = new HashMap<>() {
        {
            put("Tomato", new Ingredient("Tomato", 10, 2.35));
            put("Onion", new Ingredient("Onion", 6, 1.45));
            put("Olives", new Ingredient("Olives", 2, 10.78));
            put("Pepper", new Ingredient("Pepper", 4.5, 3.));
            put("Mushrooms", new Ingredient("Mushrooms", 6, 5.65));
            put("Basil", new Ingredient("Basil", 0.8, 3.3));
            put("Cheese", new Ingredient("Cheese", 6, 13));
            put("Salami", new Ingredient("Salami", 4, 19));
            put("Sausages", new Ingredient("Sausages", 4, 12));
            put("Flour", new Ingredient("Flour", 25, 5));
            put("Chicken", new Ingredient("Chicken", 5, 8));
            put("Pineapple", new Ingredient("Pineapple", 3, 10));
            put("Burger bread", new Ingredient("Burger bread", 15, 7.78));
            put("Ground beef", new Ingredient("Ground beef", 8, 14));
            put("Potato", new Ingredient("Potato", 20, 4.60));
            put("Pork ribs", new Ingredient("Pork ribs", 14, 16));
            put("Pork meat", new Ingredient("Pork meat", 14,  18));
            put("Beef meat", new Ingredient("Beef meat", 14,  22));
        }
    };

    public static HashMap<String, Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public static double getIngredientCostPerKGFromList(String nameOfIngredient) {

        return ingredientsList.get(nameOfIngredient).getCostPerKG();
    }

    public static double calculateIngredientCost(double costPerKG, double ingredientWeight) {
        return costPerKG * ingredientWeight;
    }

    public static double calculateTotalCost(HashMap<String, Ingredient> ingredients) {
        double totalCost = 0;
        for (Ingredient ingredient : ingredients.values()) {
            totalCost += ingredient.getCostByWeight();
        }
        return totalCost;
    }

    public static double calculateTotalWeight(HashMap<String, Ingredient> ingredients) {
        double totalWeight = 0;
        for (Ingredient ingredient : ingredients.values()) {
            totalWeight += ingredient.getWeight();
        }
        return totalWeight;
    }

//    public <T> void cookFood(CookedFood recipe, HashSet<T> ingredientsList) {
//        HashMap<String, HashSet<T>>  = new HashMap<>();
//    }

}
