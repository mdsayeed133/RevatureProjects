package com.revature.services;

import com.revature.daos.AccountsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountsDAO accountsDAO;

    @Autowired
    public AccountService(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    public boolean updateAmount(int id, double amount) {
        return accountsDAO.updateAmount(id, amount);
    }

}