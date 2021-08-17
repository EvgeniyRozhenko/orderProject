package com.solvd.orderProject.institution;

public enum TypeOfInstitution {
    PIZZERIA ("Pizzeria"),
    BBQ ("BBQ"),
    FAST_FOOD ("Fast food");

    private final String realName;

    TypeOfInstitution(String realName) {
        this.realName = realName;
    }
}
