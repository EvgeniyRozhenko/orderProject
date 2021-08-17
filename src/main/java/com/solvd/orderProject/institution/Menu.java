package com.solvd.orderProject.institution;

import com.solvd.orderProject.beverage.Alcohol;
import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.beverage.Juice;
import com.solvd.orderProject.beverage.Soda;
import com.solvd.orderProject.food.FoodRecipe;

import java.util.HashSet;

public class Menu {

    HashSet<FoodRecipe> foodMenu;
    HashSet<Beverage> beverageMenu;

    public Menu() {}

    public Menu(TypeOfInstitution typeOfInstitution) {
        switch(typeOfInstitution) {
            case BBQ:
                this.foodMenu = new HashSet<>(){
                    {
                        add(FoodRecipe.NEW_YORK_STAKE);
                        add(FoodRecipe.PORK_RIBS);
                        add(FoodRecipe.SHASHLIK);
                        add(FoodRecipe.NUGGETS);
                    }
                };
                this.beverageMenu = new HashSet<>(){
                    {
                        add(new Alcohol("Leffe", 0.5, "Blonde", 4, 4.6));
                        add(new Alcohol("Vodka", 0.7, "Soft", 10, 40));
                        add(new Alcohol("Whisky", 1, "Irish", 16, 40));
                        add(new Soda("Cola", 0.33, "Cola", 1.5, "Strong"));
                    }
                };
                break;
            case PIZZERIA:
                this.foodMenu = new HashSet<>(){
                    {
                        add(FoodRecipe.MARGARITA);
                        add(FoodRecipe.HAWAIIAN);
                        add(FoodRecipe.SALAMI);
                    }
                };
                this.beverageMenu = new HashSet<>(){
                    {
                        add(new Soda("Cola", 0.33, "Cola", 1.5, "Strong"));
                        add(new Soda("Sprite", 0.33, "Lemon", 1.5, "Strong"));
                        add(new Juice("Rich", 0.7, "Cherry", 4, new char[]{'C','E'}, "No pulp"));
                    }
                };
                break;
            case FAST_FOOD:
                this.foodMenu = new HashSet<>(){
                    {
                        add(FoodRecipe.BURGER);
                        add(FoodRecipe.CHEESE_BURGER);
                        add(FoodRecipe.CHICKEN_BURGER);
                        add(FoodRecipe.FRENCH_FRIES);
                    }
                };
                this.beverageMenu = new HashSet<>(){
                    {
                        add(new Soda("Cola", 0.33, "Cola", 1.5, "Strong"));
                        add(new Soda("Cola", 0.5, "Cola", 2.5, "Strong"));
                        add(new Soda("Sprite", 0.33, "Lemon", 1.5, "Strong"));
                        add(new Soda("Sprite", 0.5, "Lemon", 2.5, "Strong"));
                        add(new Soda("Fanta", 0.33, "Orange", 1.5, "Strong"));
                        add(new Soda("Fanta", 0.5, "Orange", 2.5, "Strong"));
                    }
                };
                break;
        }

    }
    public HashSet<FoodRecipe> getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(HashSet<FoodRecipe> foodMenu) {
        this.foodMenu = foodMenu;
    }

    public HashSet<Beverage> getBeverageMenu() {
        return beverageMenu;
    }

    public void setBeverageMenu(HashSet<Beverage> beverageMenu) {
        this.beverageMenu = beverageMenu;
    }

    @Override
    public String toString() {
        return "Menu {" + "\n" +
                "foodMenu: " + foodMenu +
                ", \n" + "beverageMenu: " + beverageMenu +
                '}';
    }
}
