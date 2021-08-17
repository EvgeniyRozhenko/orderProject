package com.solvd.orderProject.personData;

import com.solvd.orderProject.institution.FoodInstitution;
import com.solvd.orderProject.institution.Menu;
import com.solvd.orderProject.institution.TypeOfInstitution;
import com.solvd.orderProject.util.NegativeBalanceResultException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Client extends Person {
    private int discount;
    private String address;

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    public Client(String name, String surname, int telephoneNumber, String address) {
        super(name, surname, telephoneNumber);
        this.address = address;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + '\n' +
                "address: " + address + '\n' +
                "discount: " + discount + '\n' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return discount == client.discount && address.equals(client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, address);
    }

    @Override
    public void toCallSomeone(String message) {
        LOGGER.info("I'm hungry! Calling to make an order...");
        LOGGER.info(message);
    }

    @Override
    public void toAnswerTheCall(String message) {
        LOGGER.info("I hope so it's about my order!");
        LOGGER.info(message);
    }

    @Override
    public void useCreditCard(CreditCard card, double amountOfPaying) {
        if (amountOfPaying > card.getMoneyBalance())
            throw new NegativeBalanceResultException("Not enough funds on the balance.");
        card.setMoneyBalance(card.getMoneyBalance() - amountOfPaying);
    }

    public void makeAnOrder(HashSet<FoodInstitution> restaurants) {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        LOGGER.info("Choose a restaurant and insert the number");

//        restaurants.forEach( institution ->  LOGGER.info(num + "): " + institution);
        for (FoodInstitution institution : restaurants) {
            LOGGER.info(num + "): " + institution);
            num++;
        }

        int chosenRestaurantNum = scanner.nextInt();
        FoodInstitution chosenRestaurant = new FoodInstitution();
        num = 1;

        for (FoodInstitution institution : restaurants) {
            if (num == chosenRestaurantNum) {
                chosenRestaurant = institution;
                break;
            }
            num++;
        }
        LOGGER.info("Please, make an order." + "\n" + chosenRestaurant.getMenu());



//        Random random = new Random();
//        int randomNumber = random.nextInt(restaurants.size());
//        int counter = 0;
//        FoodInstitution chosenRestaurant = new FoodInstitution();
//
//        for (FoodInstitution restaurant : restaurants) {
//            if (counter == randomNumber) {
//                chosenRestaurant = restaurant;
//                break;
//            }
//            counter++;
//        }
//        Menu chosenMenu = new Menu();
//        for (FoodRecipe : chosenRestaurant.getMenu().getFoodMenu()) {
//
//        }
    }
}
