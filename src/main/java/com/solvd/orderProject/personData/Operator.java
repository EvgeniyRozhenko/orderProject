package com.solvd.orderProject.personData;

import com.solvd.orderProject.util.UncorrectArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Operator extends Person {
    private int amountOfCustomerRequestPerHour;
    private int monthSalary;

    private static final Logger LOGGER = LogManager.getLogger(Operator.class);

    public Operator(String name, String surname, int telephoneNumber) {
        super(name, surname, telephoneNumber);
    }

    public int getAmountOfCustomerRequestPerHour() {
        return amountOfCustomerRequestPerHour;
    }

    public void setAmountOfCustomerRequestPerHour(int amountOfCustomerRequestPerHour) {
        this.amountOfCustomerRequestPerHour = amountOfCustomerRequestPerHour;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + '\n' +
                "amountOfCustomerRequestPerHour: " + amountOfCustomerRequestPerHour + '\n' +
                "monthSalary: " + monthSalary + '\n' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;
        if (!super.equals(o)) return false;
        Operator operator = (Operator) o;
        return amountOfCustomerRequestPerHour == operator.amountOfCustomerRequestPerHour && monthSalary == operator.monthSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfCustomerRequestPerHour, monthSalary);
    }

    @Override
    public void toCallSomeone(String message) {
        LOGGER.info("I like to bla-bla-bla with my friends!");
        LOGGER.info(message);
    }

    @Override
    public void toAnswerTheCall(String message) {
        LOGGER.info("Hello! It's " + getName() + ". How can I help you?");
        LOGGER.info(message);
    }

    public void toAnswerTheCall(String message, double deliveringTimeByHours) {
        LOGGER.info(message + deliveringTimeByHours);
    }

    @Override
    public void useCreditCard(CreditCard card, double monthSalaryAmount) {
        if (monthSalaryAmount < 0)
            throw new UncorrectArgumentException("Negative value of parameter.");
        card.setMoneyBalance(card.getMoneyBalance() + monthSalaryAmount);
    }
}
