package com.system.atm.model;

import java.util.List;

public class Bank {

    private List<Account> clients;
    private String city;
    private String postalCode;
    private String country;

    public Bank(List<Account> clients, String city, String postalCode, String country) {
        this.clients = clients;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Bank() {
    }

    public List<Account> getClients() {
        return clients;
    }

    public void setClients(List<Account> clients) {
        this.clients = clients;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addToClients(Account account) {
        this.clients.add(account);
    }
}
