package com.solvd.orderProject.personData;

public class CourierMockBuilder {
    public static Courier createMockCourier() {
        Courier courier = new Courier("Karl", "Zigelberashulz", 9834582, 15, "Scooter");
        courier.setAmountOfMaxOrdersForOneTime(2);
        courier.setPersonCreditCard(new CreditCard(15_234.5));
        return courier;
    }
}
