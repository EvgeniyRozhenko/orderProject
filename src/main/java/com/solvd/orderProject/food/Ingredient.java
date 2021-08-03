package com.solvd.orderProject.food;

import java.util.Objects;

public class Ingredient {
    private String name;
    private float weight;
    private int costPerIngredient;

    public Ingredient(String name, float weight, int costPerIngredient) {
        this.name = name;
        this.weight = weight;
        this.costPerIngredient = costPerIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getCostPerIngredient() {
        return costPerIngredient;
    }

    public void setCostPerIngredient(int costPerIngredient) {
        this.costPerIngredient = costPerIngredient;
    }

    @Override
    public String toString() {
        return "Ingredient {" +
                "name '" + name + '\'' +
                ", weight " + weight +
                ", costPerIngredient " + costPerIngredient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Float.compare(that.weight, weight) == 0 && costPerIngredient == that.costPerIngredient && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, costPerIngredient);
    }
}
