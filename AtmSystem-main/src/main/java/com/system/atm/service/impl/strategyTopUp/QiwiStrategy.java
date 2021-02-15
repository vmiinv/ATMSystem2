package com.system.atm.service.impl.strategyTopUp;

import com.system.atm.model.Account;
import com.system.atm.service.TopUpStrategy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class QiwiStrategy implements TopUpStrategy {

    Scanner in = new Scanner(System.in);
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    @Override
    public void topUp(Account account) {
        System.out.print("Your balance: ");
        System.out.println("$" + numberFormat.format(account.getCard().getBalance()));
        System.out.print("Enter your phone number: ");
        String phoneNumber = in.next();
        System.out.print("Enter password: ");
        String password = in.next();
        if (phoneNumber.equals("87021234567") && password.equals("123")) {
            System.out.print("Input amount of money: ");
            double inputMoney = in.nextDouble();
            account.getCard().setBalance(account.getCard().getBalance() + inputMoney);
            System.out.println("Balance updated to $" + numberFormat.format(account.getCard().getBalance()));
        } else {
            System.out.println("Incorrect number or password!");
        }
    }
}
