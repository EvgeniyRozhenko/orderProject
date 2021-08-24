package com.solvd.orderProject.personData;

import java.util.Objects;

public abstract class Person implements ICreditCardUsing {
    private String name;
    private String surname;
    private int telephoneNumber;
    private CreditCard personCreditCard;

    public Person() {
    }

    public Person(String name, String surname, int telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public CreditCard getPersonCreditCard() {
        return personCreditCard;
    }

    public void setPersonCreditCard(CreditCard personCreditCard) {
        this.personCreditCard = personCreditCard;
    }

    @Override
    public String toString() {
        return "Person " + this.getClass().getSimpleName() + " {" + '\n' +
                "name: " + name + '\n' +
                "surname: " + surname + '\n' +
                "telephoneNumber: " + telephoneNumber + '\n' +
                "personCreditCard: " + personCreditCard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return telephoneNumber == person.telephoneNumber && name.equals(person.name)
                && surname.equals(person.surname) && personCreditCard.equals(person.personCreditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, telephoneNumber, personCreditCard);
    }

    public String getFullName() {
        if (this.name == null || this.surname == null)
            throw new NullPointerException("Check the name or surname value.");
        return this.name + " " + this.surname;
    }
}

