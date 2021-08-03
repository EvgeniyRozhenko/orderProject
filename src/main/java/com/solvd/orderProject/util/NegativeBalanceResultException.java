package com.solvd.orderProject.util;

public class NegativeBalanceResultException extends RuntimeException {
    public NegativeBalanceResultException(String message) {
        super(message);
    }
}
