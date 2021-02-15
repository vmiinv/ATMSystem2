package com.system.atm.service;

import com.system.atm.model.Account;

public interface TopUpStrategy {
    void topUp(Account account);
}
