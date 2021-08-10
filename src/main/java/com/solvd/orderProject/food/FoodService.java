package com.solvd.orderProject.food;

import java.util.HashMap;
import java.util.HashSet;

public class FoodService {
    private static HashSet<Ingredient> ingredientsList = new HashSet<>() {
        {
            add(new Ingredient("Tomato", 10, 2.35));
            add(new Ingredient("Onion", 6, 1.45));
            add(new Ingredient("Olives", 2, 10.78));
            add(new Ingredient("Pepper", 4.5, 3.));
            add(new Ingredient("Mushrooms", 6, 5.65));
            add(new Ingredient("Basil", 0.8, 3.3));
            add(new Ingredient("Cheese", 6, 13));
            add(new Ingredient("Salami", 4, 19));
            add(new Ingredient("Sausages", 4, 12));
            add(new Ingredient("Flour", 25, 5));
            add(new Ingredient("Chicken", 5, 8));
            add(new Ingredient("Pineapple", 3, 10));
        }
    };

    public static HashSet<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

//    public <T> void cookFood(CookedFood recipe, HashSet<T> ingredientsList) {
//        HashMap<String, HashSet<T>>  = new HashMap<>();
//    }

}
