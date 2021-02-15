package com.system.atm.model;

public class Card {

    private String cardNumber;
    private String pin;
    private String expireDate;
    private String cvv;
    private double balance;

    public Card(String cardNumber, String pin, String expireDate, String cvv, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.balance = balance;
    }

    public Card() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
