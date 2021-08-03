package com.solvd.orderProject.personData;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class CreditCard {
    private final int[] cardDigitNumbers = new int[4];
    private double moneyBalance;

    public CreditCard(double moneyBalance) {
        Random random = new Random();
        for (int i = 0; i < cardDigitNumbers.length; i++) {
            cardDigitNumbers[i] = random.nextInt(8999) + 1000;
        }
        this.moneyBalance = moneyBalance;
    }

    public int[] getCardDigitNumbers() {
        return cardDigitNumbers;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    @Override
    public String toString() {
        return "CreditCard info: " +
                "cardDigitNumbers " + Arrays.toString(cardDigitNumbers).replace(",", " ") +
                ", amountBalance " + moneyBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(that.moneyBalance, moneyBalance) == 0 && Arrays.equals(cardDigitNumbers, that.cardDigitNumbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(moneyBalance);
        result = 31 * result + Arrays.hashCode(cardDigitNumbers);
        return result;
    }
}
