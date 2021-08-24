package com.solvd.orderProject.personData;

public class ClientMockBuilder {
    public static Client createMockClient() {
        Client client = new Client("Alexey", "Puplikov", 9687908, "Minsk, Pinskaya str., 14 bld.");
        client.setDiscount(7);
        client.setPersonCreditCard(new CreditCard(24_560));
        return client;
    }
}
