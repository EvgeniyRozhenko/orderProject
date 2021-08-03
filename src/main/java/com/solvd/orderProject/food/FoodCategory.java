package com.solvd.orderProject.food;

public enum FoodCategory {
    HOT(1),
    COLD(3.30f),
    FROZEN(4);

    private float maxTimeOfDelivering;

    FoodCategory(float maxTimeOfDelivering) {
        this.maxTimeOfDelivering = maxTimeOfDelivering;
    }
}