package com.system.atm.service.impl;
import com.system.atm.model.Account;
import com.system.atm.model.Bank;
import com.system.atm.service.Context;
import com.system.atm.service.impl.strategyTopUp.AnotherCardStrategy;
import com.system.atm.service.impl.strategyTopUp.QiwiStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.system.atm.service.IBankService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BankService implements IBankService {

    private final String url = "jdbc:postgresql://localhost/atm";
    private final String user = "postgres";
    private final String password = "admin";

    Scanner in = new Scanner(System.in);
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    @Override
    public void withdraw(Account account) {
        System.out.print("Your balance: ");
        System.out.println("$" + numberFormat.format(account.getCard().getBalance()));
        System.out.print("Input the amount of money you want to withdraw: ");
        double outputMoney = in.nextDouble();
        if (outputMoney <= account.getCard().getBalance()) {
            account.getCard().setBalance(account.getCard().getBalance() - outputMoney);
            System.out.println("Balance updated to $" + numberFormat.format(account.getCard().getBalance()));
        } else
            System.out.println("Not enough money!");
    }

    @Override
    public double checkBalance(Account account) {
        return account.getCard().getBalance();
    }

    @Override
    public void topUp(Account account) {
        Context tContext = new Context();

        System.out.println("1. By cash");
        //ANOTHER CARD -- card number: 517023441233, cvv: 555
        System.out.println("2. By another card");
        // QIWI -- phone number: 87021234567, password: 123
        System.out.println("3. By Qiwi");

        int select = in.nextInt();

        switch (select) {
            case 1:
                tContext.topUp(account);
                break;
            case 2:
                tContext.setTopUpStrategy(new AnotherCardStrategy());
                tContext.topUp(account);
                break;
            case 3:
                tContext.setTopUpStrategy(new QiwiStrategy());
                tContext.topUp(account);
                break;
        }
    }

    public void init() {
        System.out.println("INITIALIZATION WORKS PERFECTLY!");
        BankService app = new BankService();
        app.connect();
    }

    public void destroy() {
        BankService app = new BankService();
        System.out.println("DESTRUCTION WORKS PERFECTLY!");
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
