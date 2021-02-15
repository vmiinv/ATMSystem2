package com.system.atm;

import com.system.atm.model.Account;
import com.system.atm.model.Bank;
import com.system.atm.model.Card;
import com.system.atm.service.IBankService;
import com.system.atm.service.impl.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Scanner in = new Scanner(System.in);

//        IBankService service = new BankService();
        Card card = context.getBean("card", Card.class);
        card.setCardNumber("1234");
        card.setBalance(21.11);
        card.setCvv("212");
        card.setExpireDate("21/02");
        card.setPin("1144");
//
        Account account = context.getBean("account", Account.class);
        account.setUsername("User");
        account.setPassword("user");
        account.setEmail("user@gmail.com");
        account.setCard(card);

        Bank bank = context.getBean("bank", Bank.class);
        bank.addToClients(account);
        bank.setCity("Almaty");
        bank.setCountry("Kazakhstan");
        bank.setPostalCode("003Z3F7");

        IBankService service = context.getBean("bankService", BankService.class);

        System.out.print("Login: ");
        String currentUsername = in.next();
        System.out.print("Password: ");
        String currentPassword = in.next();
        Account currentUser = null;

        boolean isAuth = false;

        for(Account acc : bank.getClients()) {
            if (currentUsername.equals(acc.getUsername()) && currentPassword.equals(acc.getPassword())) {
                currentUser = account;
                isAuth = true;
            }
        }

        int choice = -1;

        while (choice != 0 && isAuth) {
            System.out.println("1. Withdraw");
            System.out.println("2. Top up");
            System.out.println("3. Check Balance");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    service.withdraw(currentUser);
                    break;
                case 2:
                    service.topUp(currentUser);
                    break;
                case 3:
                    System.out.println("Balance: $" + service.checkBalance(currentUser));
                    break;
                default:
                    break;
            }
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
