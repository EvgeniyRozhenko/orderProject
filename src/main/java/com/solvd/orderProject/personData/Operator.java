package com.solvd.orderProject.personData;

import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.food.FoodRecipe;
import com.solvd.orderProject.institution.FoodInstitution;
import com.solvd.orderProject.numberUtil.NumberUtil;
import com.solvd.orderProject.util.UncorrectArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Operator extends Person implements IShow {
    private int amountOfCustomerRequestPerHour;
    private int monthSalary;
    private HashSet<FoodInstitution> foodInstitutions;

    private static final Logger LOGGER = LogManager.getLogger(Operator.class);

    public Operator(String name, String surname, int telephoneNumber) {
        super(name, surname, telephoneNumber);
    }

    public int getAmountOfCustomerRequestPerHour() {
        return amountOfCustomerRequestPerHour;
    }

    public void setAmountOfCustomerRequestPerHour(int amountOfCustomerRequestPerHour) {
        this.amountOfCustomerRequestPerHour = amountOfCustomerRequestPerHour;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public HashSet<FoodInstitution> getFoodInstitutions() {
        return foodInstitutions;
    }

    public void setFoodInstitutions(HashSet<FoodInstitution> foodInstitutions) {
        this.foodInstitutions = foodInstitutions;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + '\n' +
                "amountOfCustomerRequestPerHour: " + amountOfCustomerRequestPerHour + '\n' +
                "monthSalary: " + monthSalary + '\n' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;
        if (!super.equals(o)) return false;
        Operator operator = (Operator) o;
        return amountOfCustomerRequestPerHour == operator.amountOfCustomerRequestPerHour && monthSalary == operator.monthSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfCustomerRequestPerHour, monthSalary);
    }

    @Override
    public void useCreditCard(CreditCard card, double monthSalaryAmount) {
        if (monthSalaryAmount < 0)
            throw new UncorrectArgumentException("Negative value of parameter.");
        card.setMoneyBalance(card.getMoneyBalance() + monthSalaryAmount);
    }

    @Override
    public Integer makeRestaurantSelection(Client client) {
        System.out.println("Hello " + client.getName() + "! " + "Please, choose what type of restaurant do you prefer?");
        this.getFoodInstitutions().forEach(restaurant -> {
            System.out.println(restaurant.getId() + "." + restaurant.getName());
        });
        List<Integer> restaurantIds = this.getFoodInstitutions().stream().map(FoodInstitution::getId).collect(Collectors.toList());

        int selectedRestaurantId;
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = in.nextLine();
            if (NumberUtil.isNumeric(userInput)
                    && restaurantIds.stream().anyMatch(restaurantId -> restaurantId == Integer.parseInt(userInput))) {
                selectedRestaurantId = Integer.parseInt(userInput);
                break;
            } else {
                System.out.println("Please enter correct restaurant index");
            }
        }
        return selectedRestaurantId;
    }

    @Override
    public List<Integer> makeBeverageSelection(FoodInstitution selectedRestaurant) {
        Scanner in = new Scanner(System.in);


        List<Integer> selectedBeverageIds = new ArrayList<>();
        HashSet<Beverage> beverages = selectedRestaurant.getMenu().getBeverageMenu();
        List<Integer> beverageIds = beverages.stream()
                .map(Beverage::getId)
                .collect(Collectors.toList());
        System.out.println("Beverage: ");
        beverages.forEach(beverage -> {
            System.out.println(beverage.showItemInformation());
        });
        System.out.println("Please, choose beverage. Put zero for exit.");
        while (true) {
            String userInput = in.nextLine();
            if (NumberUtil.isNumeric(userInput)
                    && beverageIds.stream().anyMatch(beverageId -> beverageId == Integer.parseInt(userInput))) {
                selectedBeverageIds.add(Integer.parseInt(userInput));
            } else if (NumberUtil.isNumeric(userInput) && Integer.parseInt(userInput) == 0) {
                break;
            } else {
                System.out.println("Please enter correct beverage index");
            }
        }
        return selectedBeverageIds;
    }

    @Override
    public List<Integer> makeFoodRecipeSelection(FoodInstitution selectedRestaurant) {
        Scanner in = new Scanner(System.in);

        List<Integer> selectedFoodRecipesIds = new ArrayList<>();
        HashSet<FoodRecipe> foodRecipes = selectedRestaurant.getMenu().getFoodMenu();
        List<Integer> foodRecipesIds = foodRecipes.stream()
                .map(FoodRecipe::ordinal)
                .collect(Collectors.toList());
        System.out.println("Food recipes: ");
        foodRecipes.forEach(foodRecipe -> {
            System.out.println(foodRecipe.showItemInformation());
        });
        System.out.println("Please, choose food recipe. Put zero for exit.");
        while (true) {
            String userInput = in.nextLine();
            if (NumberUtil.isNumeric(userInput)
                    && foodRecipesIds.stream().anyMatch(beverageId -> beverageId == Integer.parseInt(userInput) - 1)) {
                selectedFoodRecipesIds.add(Integer.parseInt(userInput) - 1);
            } else if (NumberUtil.isNumeric(userInput) && Integer.parseInt(userInput) == 0) {
                break;
            } else {
                System.out.println("Please enter correct food recipe index");
            }
        }
        return selectedFoodRecipesIds;
    }
}
