package com.system.atm.service;

import com.system.atm.model.Account;
import com.system.atm.service.impl.strategyTopUp.CashStrategy;

public class Context {
    private TopUpStrategy topUpStrategy;


    public Context(TopUpStrategy topUpStrategy) {
        this.topUpStrategy = topUpStrategy;
    }

    public Context() {
        this.topUpStrategy = new CashStrategy();
    }

    public void topUp(Account account) {
        topUpStrategy.topUp(account);
    }

    public void setTopUpStrategy(TopUpStrategy TopUpStrategy) {
        this.topUpStrategy = TopUpStrategy;
    }

}
