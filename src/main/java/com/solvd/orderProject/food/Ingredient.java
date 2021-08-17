package com.solvd.orderProject.food;

import java.util.Objects;

public class Ingredient {
    private String name;
    private double weight;
    private double costPerKG;
    private double costByWeight;

    public Ingredient(String name, double weight, double costPerKG) {
        this.name = name;
        this.weight = weight;
        this.costPerKG = costPerKG;
        this.costByWeight = FoodService.calculateIngredientCost(this.costPerKG, this.weight);
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

    public double getCostPerKG() {
        return costPerKG;
    }

    public void setCostPerKG(double costPerKG) {
        this.costPerKG = costPerKG;
    }

    public double getCostByWeight() {
        return costByWeight;
    }

    public void setCostByWeight(double costByWeight) {
        this.costByWeight = costByWeight;
    }

    @Override
    public String toString() {
        return "Ingredient {" +
                "name '" + name + '\'' +
                ", weight " + weight +
                ", costPerKG " + costPerKG +
                ", costByWeight " + costByWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.weight, weight) == 0 && Double.compare(that.costPerKG, costPerKG) == 0 && Double.compare(that.costByWeight, costByWeight) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, costPerKG, costByWeight);
    }
}
