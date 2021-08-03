package com.solvd.orderProject;

import com.solvd.orderProject.beverage.Alcohol;
import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.beverage.Juice;
import com.solvd.orderProject.beverage.Soda;
import com.solvd.orderProject.food.CookedFood;
import com.solvd.orderProject.food.FoodCategory;
import com.solvd.orderProject.food.Ingredient;
import com.solvd.orderProject.institution.FoodInstitution;
import com.solvd.orderProject.institution.TypeOfInstitution;
import com.solvd.orderProject.order.Order;
import com.solvd.orderProject.personData.Client;
import com.solvd.orderProject.personData.Courier;
import com.solvd.orderProject.personData.CreditCard;
import com.solvd.orderProject.personData.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        //restaurant creation
        FoodInstitution restaurant = new FoodInstitution("Rakovkij Brovar", "Minsk, Vitebskaya str., 10 bld.", TypeOfInstitution.PIZZERIA, "5 stars", true);
        LOGGER.info(restaurant);

        //restaurant purchases
        Set<String> purchaseOfIngredients = new HashSet<>() {
            {
                add("salami");
                add("wheat flour");
                add("tomatoes");
                add("cheese");
                add("basil");
                add("mushrooms");
                add("eggs");
                add("peppers");
                add("olive oil");
                add("onions");
            }
        };
        HashSet<Ingredient> purchasedIngredients = restaurant.buyIngredients(purchaseOfIngredients);

        List<Beverage> purchaseOfBeverage = new ArrayList<>() {
            {
                add(new Alcohol("Vodka", 1, "bitter", 12, 40));
                add(new Alcohol("Leffe beer", 0.5, "different kinds", 4, 4.6));
                add(new Juice("Sandora", 0.7, "multifruits", 1.2, new char[]{'C','E'}, "Light"));
                add(new Soda("Coca-cola", 0.33, "Cola", 0.7,"Strong"));
            }
        };

        //people creation
        Operator operator = new Operator("Julia", "Martishkina", 5461420);
        operator.setMonthSalary(850);
        operator.setAmountOfCustomerRequestPerHour(12);
        operator.setPersonCreditCard(new CreditCard(367.98));
        LOGGER.info(operator);

        Courier courier = new Courier("Karl", "Zigelberashulz", 9834582, 15, "Scooter");
        courier.setAmountOfMaxOrdersForOneTime(2);
        courier.setPersonCreditCard(new CreditCard(15_234.5));
        LOGGER.info(courier);

        Client client = new Client("Alexey", "Puplikov", 9687908, "Minsk, Pinskaya str., 14 bld.");
        client.setDiscount(7);
        client.setPersonCreditCard(new CreditCard(24_560));
        LOGGER.info(client);

        //order & cooking
        operator.toAnswerTheCall("Today we have special price for every second pizza! 50% discount!");
        client.toCallSomeone("I would like to order two pizzas. First is Margarita, second with salami. Plus one beer and one coke? please. My address is " + client.getAddress());
        operator.toAnswerTheCall("Your order is accepted. Delivering time is approximately ", 0.35);

        ArrayList<CookedFood> foodOrderList = new ArrayList<>(2);
        Set<Ingredient> ingredientsForPizzaMargarita = restaurant.getIngredientsForPizza("Margarita", purchasedIngredients);
        double weightOfIngredientsForPizzaMargarita = restaurant.calculateTotalWeightOfFood(ingredientsForPizzaMargarita);
        CookedFood pizzaMargarita = new CookedFood("Margarita", ingredientsForPizzaMargarita, weightOfIngredientsForPizzaMargarita, "Large", FoodCategory.HOT);
        Set<Ingredient> ingredientsForPizzaSalami = restaurant.getIngredientsForPizza("Salami", purchasedIngredients);
        double weightOfIngredientsForPizzaSalami = restaurant.calculateTotalWeightOfFood(ingredientsForPizzaSalami);
        CookedFood pizzaSalami = new CookedFood("Salami", ingredientsForPizzaSalami, weightOfIngredientsForPizzaSalami, "Large", FoodCategory.HOT);
        foodOrderList.add(pizzaMargarita);
        foodOrderList.add(pizzaSalami);
        ArrayList<Beverage> beverageOrderList = new ArrayList<>(2);
        beverageOrderList.add(purchaseOfBeverage.get(1));
        beverageOrderList.add(purchaseOfBeverage.get(3));

        Order orderHelper = new Order();
        ArrayList<Ingredient> ingredientsForTwoPizzas = new ArrayList<>();
        ingredientsForTwoPizzas.addAll(ingredientsForPizzaMargarita);
        ingredientsForTwoPizzas.addAll(ingredientsForPizzaSalami);
        double totalCostOfOrderedFood = orderHelper.calculateTotalCostOfFood(ingredientsForTwoPizzas);



        Order orderNumber1 = new Order(1, restaurant.getName(), client.getFullName(), foodOrderList,
                foodOrderList.size(), beverageOrderList, beverageOrderList.size(), operator.getFullName(),
                courier.getFullName(), 30, 5, totalCostOfOrderedFood);
    }
}
