/*
1) сделать 3 класса-дженерика или интерфейса, или метода.
2) 5 коллекций или map-ов
3)
 */
package com.solvd.orderProject;

import com.solvd.orderProject.food.FoodRecipe;
import com.solvd.orderProject.institution.FoodInstitution;
import com.solvd.orderProject.institution.RestaurantService;
import com.solvd.orderProject.personData.Client;
import com.solvd.orderProject.personData.Courier;
import com.solvd.orderProject.personData.CreditCard;
import com.solvd.orderProject.personData.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        HashSet<FoodInstitution> restaurants = RestaurantService.chooseRestaurantsRandomly(RestaurantService.getRestaurants(), 3);
        LOGGER.info("\n" + restaurants);

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

        //order
        client.makeAnOrder(restaurants);

//        operator.toAnswerTheCall("Today we have special price for every second pizza! 50% discount!");
//        client.toCallSomeone("I would like to order two pizzas. First is Margarita, second with salami. Plus one beer and one coke? please. My address is " + client.getAddress());
//        operator.toAnswerTheCall("Your order is accepted. Delivering time is approximately ", 0.35);
//
//        ArrayList<CookedFood> foodOrderList = new ArrayList<>(2);
//        Set<Ingredient> ingredientsForPizzaMargarita = restaurant.getIngredientsForPizza("Margarita", purchasedIngredients);
//        double weightOfIngredientsForPizzaMargarita = restaurant.calculateTotalWeightOfFood(ingredientsForPizzaMargarita);
//        CookedFood pizzaMargarita = new CookedFood("Margarita", ingredientsForPizzaMargarita, weightOfIngredientsForPizzaMargarita, "Large", FoodCategory.HOT);
//        Set<Ingredient> ingredientsForPizzaSalami = restaurant.getIngredientsForPizza("Salami", purchasedIngredients);
//        double weightOfIngredientsForPizzaSalami = restaurant.calculateTotalWeightOfFood(ingredientsForPizzaSalami);
//        CookedFood pizzaSalami = new CookedFood("Salami", ingredientsForPizzaSalami, weightOfIngredientsForPizzaSalami, "Large", FoodCategory.HOT);
//        foodOrderList.add(pizzaMargarita);
//        foodOrderList.add(pizzaSalami);
//        ArrayList<Beverage> beverageOrderList = new ArrayList<>(2);
//        beverageOrderList.add(purchaseOfBeverage.get(1));
//        beverageOrderList.add(purchaseOfBeverage.get(3));
//
//        Order orderHelper = new Order();
//        ArrayList<Ingredient> ingredientsForTwoPizzas = new ArrayList<>();
//        ingredientsForTwoPizzas.addAll(ingredientsForPizzaMargarita);
//        ingredientsForTwoPizzas.addAll(ingredientsForPizzaSalami);
//        double totalCostOfOrderedFood = orderHelper.calculateTotalCostOfFood(ingredientsForTwoPizzas);
//
//
//
//        Order orderNumber1 = new Order(1, restaurant.getName(), client.getFullName(), foodOrderList,
//                foodOrderList.size(), beverageOrderList, beverageOrderList.size(), operator.getFullName(),
//                courier.getFullName(), 30, 5, totalCostOfOrderedFood);
    }
}
