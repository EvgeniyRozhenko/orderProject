package com.solvd.orderProject.institution;

import com.solvd.orderProject.food.Ingredient;
import com.solvd.orderProject.logistic.Address;
import com.solvd.orderProject.numberUtil.NumberUtil;
import com.solvd.orderProject.util.UncorrectArgumentException;
import com.solvd.orderProject.util.ZeroSizeException;

import java.util.*;

public class RestaurantService {
    private final static HashSet<FoodInstitution> restaurants = new LinkedHashSet<>() {
        {
            add(new FoodInstitution(1, "Rakovkij Brovar", new Address("Minsk", "Vitebskaya", "10", new double[]{53.904240, 27.548714}), TypeOfInstitution.PIZZERIA));
            add(new FoodInstitution(2, "American BBQ", new Address("Minsk", "Volodko", "6/6", new double[]{53.881914, 27.561895}), TypeOfInstitution.BBQ));
            add(new FoodInstitution(3, "Burger King", new Address("Minsk", "Nemiga", "12-b", new double[]{53.902331, 27.548712}), TypeOfInstitution.FAST_FOOD));
            add(new FoodInstitution(4, "McDonald's", new Address("Minsk", "Prospekt Dzerzhinskogo", "59", new double[]{53.874504, 27.496513}), TypeOfInstitution.FAST_FOOD));
            add(new FoodInstitution(5, "Dominos", new Address("Minsk", "Pobediteley str", "84", new double[]{53.937747, 27.488022}), TypeOfInstitution.PIZZERIA));
            add(new FoodInstitution(6, "BBQ Chef Arts", new Address("Minsk", "Slobodskaya", "27", new double[]{53.858473, 27.433077}), TypeOfInstitution.BBQ));
            add(new FoodInstitution(7, "KFC", new Address("Minsk", "Babruyskaya", "19", new double[]{53.890623, 27.554792}), TypeOfInstitution.FAST_FOOD));
        }
    };

    public static HashSet<FoodInstitution> getRestaurants() {
        return restaurants;
    }

    public static HashSet<FoodInstitution> chooseRestaurantsRandomly(int restaurantQuantity) {
        if (restaurantQuantity > restaurants.size() || restaurantQuantity == 0) {
            throw new UncorrectArgumentException("Parameter shouldn't be 0 or more then " + restaurants.size());
        }
        ArrayList<FoodInstitution> arrayBuffer = new ArrayList<>(restaurants);
        HashSet<FoodInstitution> chosenRestaurants = new HashSet<>();
        Random random = new Random();
        int[] savedRandoms = new int[restaurantQuantity];
        int newIndex;

        for (int i = 0; i < restaurantQuantity; i++) {
            newIndex = random.nextInt(restaurants.size());
            savedRandoms[i] = -1;
            for(int j = 0; j <= i; j++) {
                if (savedRandoms[j] == newIndex) {
                    newIndex = random.nextInt(restaurants.size());
                    j = -1;
                }
            }
            chosenRestaurants.add(arrayBuffer.get(newIndex));
            savedRandoms[i] = newIndex;
        }

        return chosenRestaurants;
    }

    public static Integer getSelectedRestaurantId(List<Integer> restaurantIds) {
        int selectedRestaurantId;
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = in.nextLine();
            if (NumberUtil.isNumeric(userInput)
                    && restaurantIds.stream().anyMatch(restaurantId -> restaurantId == Integer.parseInt(userInput))){
                selectedRestaurantId = Integer.parseInt(userInput);
                break;
            } else{
                System.out.println("Please enter correct restaurant index");
            }
        }
        return selectedRestaurantId;
    }

//    public HashSet<Ingredient> buyIngredients(Set<String> listOfNeededProducts) {
//
//        if (listOfNeededProducts.size() == 0) throw new ZeroSizeException("Set parameter cannot have zero size.");
//
//        HashSet<Ingredient> purchasedIngredients = new HashSet<>(listOfNeededProducts.size());
//        Random random = new Random();
//        for (String product : listOfNeededProducts) {
//            purchasedIngredients.add(new Ingredient(product, random.nextFloat() + 1, random.nextInt(11)));
//        }
//        return purchasedIngredients;
//    }
}
