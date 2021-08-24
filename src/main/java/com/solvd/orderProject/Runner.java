package com.solvd.orderProject;

import com.solvd.orderProject.beverage.Beverage;
import com.solvd.orderProject.personData.*;
import com.solvd.orderProject.food.FoodRecipe;
import com.solvd.orderProject.institution.FoodInstitution;
import com.solvd.orderProject.institution.Menu;
import com.solvd.orderProject.institution.RestaurantService;
import com.solvd.orderProject.order.Order;
import org.apache.commons.lang3.time.CalendarUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        //restaurants creation
        HashSet<FoodInstitution> restaurants = RestaurantService.chooseRestaurantsRandomly(3);
        LOGGER.info("\n" + restaurants);

        //people creation
        Client client = ClientMockBuilder.createMockClient();
        Operator operator = OperatorMockBuilder.createMockOperator(restaurants);
        Courier courier = CourierMockBuilder.createMockCourier();

        //order
        Integer selectedRestaurantId = operator.makeRestaurantSelection(client);

        Optional<FoodInstitution> selectedRestaurant = operator.getFoodInstitutions().stream()
                .filter(institution -> institution.getId() == selectedRestaurantId)
                .findFirst();

        if (selectedRestaurant.isPresent()) {
            FoodInstitution restaurant = selectedRestaurant.get();

            List<Integer> selectedBeverageIds = operator.makeBeverageSelection(restaurant);
            List<Integer> selectedFoodRecipeIds = operator.makeFoodRecipeSelection(restaurant);

            List<FoodRecipe> foodRecipes = Menu.collectFoodRecipes(selectedFoodRecipeIds, restaurant.getMenu().getFoodMenu());
            List<Beverage> beverages = Menu.collectBeverages(selectedBeverageIds, restaurant.getMenu().getBeverageMenu());

            Order order = new Order(100, restaurant.getName(), client.getFullName(), foodRecipes,
            foodRecipes.size(), beverages, beverages.size(),
            operator.getFullName(), courier.getFullName(), 0);

            System.out.println(order);
        } else {
            throw new RuntimeException("Restaurant is not selected");
        }
    }
}
