package com.solvd.orderProject.logistic;

public interface ICalculatingDistance {

    double countDistanceValue(double[] pointXY1, double[] pointXY2);
    double countDistanceCost(boolean isPayable, double distanceValue, double costPerKilometer);
}

