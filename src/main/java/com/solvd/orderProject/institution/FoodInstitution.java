package com.solvd.orderProject.institution;

import com.solvd.orderProject.logistic.Address;
import com.solvd.orderProject.util.ZeroSizeException;
import com.solvd.orderProject.food.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class FoodInstitution {
    private String name;
    private Address address;
    private TypeOfInstitution typeOfFoodInstitution;
    private Menu menu;
    private String serviceQuality;

    private static final Logger LOGGER = LogManager.getLogger(FoodInstitution.class);

    public FoodInstitution() {}

    public FoodInstitution(String name, Address address, TypeOfInstitution typeOfFoodInstitution) {
        this.name = name;
        this.address = address;
        this.typeOfFoodInstitution = typeOfFoodInstitution;
        this.menu = new Menu(this.typeOfFoodInstitution);
    }

    public FoodInstitution(String name, Address address, String typeOfFoodInstitution) {
        this.name = name;
        this.address = address;
        switch (typeOfFoodInstitution.toUpperCase().trim()) {
            case "BBQ":
                this.typeOfFoodInstitution = TypeOfInstitution.BBQ;
                break;
            case "PIZZERIA":
                this.typeOfFoodInstitution = TypeOfInstitution.PIZZERIA;
                break;
            default:
                this.typeOfFoodInstitution = TypeOfInstitution.FAST_FOOD;
                break;
        }
        this.menu = new Menu(this.typeOfFoodInstitution);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TypeOfInstitution getTypeOfFoodInstitution() {
        return typeOfFoodInstitution;
    }

    public void setTypeOfFoodInstitution(TypeOfInstitution typeOfFoodInstitution) {
        this.typeOfFoodInstitution = typeOfFoodInstitution;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getServiceQuality() {
        return serviceQuality;
    }

    public void setServiceQuality(String serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodInstitution)) return false;
        FoodInstitution that = (FoodInstitution) o;
        return name.equals(that.name) && address.equals(that.address)
                && typeOfFoodInstitution == that.typeOfFoodInstitution
                && menu.equals(that.menu) && serviceQuality.equals(that.serviceQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, typeOfFoodInstitution, menu, serviceQuality);
    }

    @Override
    public String toString() {
        return "FoodInstitution { " +
                "name: " + '\"' + name.toUpperCase() + '\"' +
                "; address: '" + address + '\'' +
                "; typeOfFoodInstitution: " + typeOfFoodInstitution +
                "; menu " + menu +
                "; serviceQuality: " + serviceQuality + " " +
                '}' + '\n';
    }

    public static HashSet<FoodInstitution> createRestaurantSetByConsole(int restaurantsQuantity) {
        Scanner sc = new Scanner(System.in);
        HashSet<FoodInstitution> restaurants = new HashSet<>(restaurantsQuantity);
        for (int i = 0; i < restaurantsQuantity; i++) {
            LOGGER.info("Enter the name for the restaurant");
            String restaurantName = sc.nextLine();
            LOGGER.info("Enter the address");
            String restaurantAddress = sc.nextLine();
            LOGGER.info("Choose the type of restaurant: Pizzeria, BBQ or Fast Food");
            String restaurantType = sc.nextLine();
            restaurants.add(new FoodInstitution());
        }
        return restaurants;
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
