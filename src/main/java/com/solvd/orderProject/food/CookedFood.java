package com.solvd.orderProject.food;

import java.util.Objects;
import java.util.Set;

public class CookedFood {
    private String name;
    private Set<Ingredient> ingredients;
    private double weight;
    private String size;
    private FoodCategory maxTimeToDeliverByFoodCategory;

    public CookedFood(String name, Set<Ingredient> ingredients, double weight, String size, FoodCategory maxTimeToDeliverByFoodCategory) {
        this.name = name;
        this.ingredients = ingredients;
        this.weight = weight;
        this.size = size;
        this.maxTimeToDeliverByFoodCategory = maxTimeToDeliverByFoodCategory;
    }

    public CookedFood(String name, Set<Ingredient> ingredients, FoodCategory maxTimeToDeliverByFoodCategory) {
        this.name = name;
        this.ingredients = ingredients;
        this.maxTimeToDeliverByFoodCategory = maxTimeToDeliverByFoodCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public FoodCategory getMaxTimeToDeliverByFoodCategory() {
        return maxTimeToDeliverByFoodCategory;
    }

    public void setMaxTimeToDeliverByFoodCategory(FoodCategory maxTimeToDeliverByFoodCategory) {
        this.maxTimeToDeliverByFoodCategory = maxTimeToDeliverByFoodCategory;
    }

    @Override
    public String toString() {
        return "CookedFood { " + '\n' +
                "name: " + '\"' + name + '\"' + '\n' +
                "ingredients: " + ingredients + '\n' +
                "weight: " + weight + '\n' +
                "size: " + size + '\n' +
                "maxTimeToDeliverByFoodCategory = " + maxTimeToDeliverByFoodCategory.name() + " " +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CookedFood)) return false;
        CookedFood that = (CookedFood) o;
        return Double.compare(that.weight, weight) == 0 && name.equals(that.name) && ingredients.equals(that.ingredients)
                && size.equals(that.size) && maxTimeToDeliverByFoodCategory == that.maxTimeToDeliverByFoodCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, weight, size, maxTimeToDeliverByFoodCategory);
    }
}
