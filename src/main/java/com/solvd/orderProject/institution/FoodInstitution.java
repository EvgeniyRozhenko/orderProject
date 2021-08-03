package com.solvd.orderProject.institution;

import com.solvd.orderProject.util.ZeroSizeException;
import com.solvd.orderProject.food.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class FoodInstitution {
    private String name;
    private String address;
    private TypeOfInstitution typeOfFoodInstitution;
    private String serviceQuality;
    private boolean michelinAward;

    private static final Logger LOGGER = LogManager.getLogger(FoodInstitution.class);

    public FoodInstitution(String name, String address, TypeOfInstitution typeOfFoodInstitution,
                           String serviceQuality, boolean michelinAward) {
        this.name = name;
        this.address = address;
        this.typeOfFoodInstitution = typeOfFoodInstitution;
        this.serviceQuality = serviceQuality;
        this.michelinAward = michelinAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeOfInstitution getTypeOfFoodInstitution() {
        return typeOfFoodInstitution;
    }

    public void setTypeOfFoodInstitution(TypeOfInstitution typeOfFoodInstitution) {
        this.typeOfFoodInstitution = typeOfFoodInstitution;
    }

    public String getServiceQuality() {
        return serviceQuality;
    }

    public void setServiceQuality(String serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

    public boolean getMichelinAward() {
        return michelinAward;
    }

    public void setMichelinAward(boolean michelinAward) {
        this.michelinAward = michelinAward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodInstitution)) return false;
        FoodInstitution that = (FoodInstitution) o;
        return michelinAward == that.michelinAward && name.equals(that.name) && address.equals(that.address)
                && typeOfFoodInstitution == that.typeOfFoodInstitution && serviceQuality.equals(that.serviceQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, typeOfFoodInstitution, serviceQuality, michelinAward);
    }

    @Override
    public String toString() {
        return "FoodInstitution { " +
                "name: " + '\"' + name.toUpperCase() + '\"' +
                "; address: '" + address + '\'' +
                "; typeOfFoodInstitution: " + typeOfFoodInstitution +
                "; serviceQuality: " + serviceQuality +
                "; michelinAward: " + michelinAward + " " +
                '}';
    }

    public HashSet<Ingredient> buyIngredients(Set<String> listOfNeededProducts) {

        if (listOfNeededProducts.size() == 0) throw new ZeroSizeException("Set parameter cannot have zero size.");

        HashSet<Ingredient> purchasedIngredients = new HashSet<>(listOfNeededProducts.size());
        Random random = new Random();
        for (String product : listOfNeededProducts) {
            purchasedIngredients.add(new Ingredient(product, random.nextFloat() + 1, random.nextInt(11)));
        }
        return purchasedIngredients;
    }

    public Set<Ingredient> getIngredientsForPizza(String nameOfPizza, HashSet<Ingredient> purchasedIngredients) {
        Set<Ingredient> ingredientsForPizza = new HashSet<>();
        switch (nameOfPizza.toLowerCase()) {
            case ("margarita"):
                for (Ingredient oneIngredient : purchasedIngredients) {
                    if (oneIngredient.getName().equals("wheat flour") || oneIngredient.getName().equals("tomatoes")
                            || oneIngredient.getName().equals("cheese") || oneIngredient.getName().equals("basil")
                            || oneIngredient.getName().equals("eggs") || oneIngredient.getName().equals("olive oil")) {
                        ingredientsForPizza.add(oneIngredient);
                    }
                }
                break;
            case ("salami"):
                for (Ingredient oneIngredient : purchasedIngredients) {
                    if (oneIngredient.getName().equals("wheat flour") || oneIngredient.getName().equals("peppers")
                            || oneIngredient.getName().equals("cheese") || oneIngredient.getName().equals("basil")
                            || oneIngredient.getName().equals("eggs") || oneIngredient.getName().equals("olive oil")
                            || oneIngredient.getName().equals("salami") || oneIngredient.getName().equals("onions")) {
                        ingredientsForPizza.add(oneIngredient);
                    }
                }
                break;
            default:
                LOGGER.info("There is no such recipe...");
        }
        return ingredientsForPizza;
    }

    public double calculateTotalWeightOfFood(Set<Ingredient> ingredients) {
        if (ingredients.size() == 0)
            throw new ZeroSizeException("Zero size of parameter.");
        double weightCounter = 0;
        for (Ingredient oneIngredient : ingredients) {
            weightCounter += oneIngredient.getWeight();
        }
        return weightCounter;
    }
}
