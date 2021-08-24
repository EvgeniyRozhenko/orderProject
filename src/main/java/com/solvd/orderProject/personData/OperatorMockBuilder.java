package com.solvd.orderProject.personData;

import com.solvd.orderProject.institution.FoodInstitution;

import java.util.HashSet;

public class OperatorMockBuilder {
    public static Operator createMockOperator(HashSet<FoodInstitution> foodInstitutions) {
        Operator operator = new Operator("Julia", "Martishkina", 5461420);
        operator.setMonthSalary(850);
        operator.setAmountOfCustomerRequestPerHour(12);
        operator.setPersonCreditCard(new CreditCard(367.98));
        operator.setFoodInstitutions(foodInstitutions);
        return operator;
    }
}
