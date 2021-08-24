package com.solvd.orderProject.personData;

import com.solvd.orderProject.institution.FoodInstitution;

import java.util.List;

public interface IShow {
    Integer makeRestaurantSelection(Client client);
    List<Integer> makeBeverageSelection(FoodInstitution selectedRestaurant);
    List<Integer> makeFoodRecipeSelection(FoodInstitution selectedRestaurant);
}
