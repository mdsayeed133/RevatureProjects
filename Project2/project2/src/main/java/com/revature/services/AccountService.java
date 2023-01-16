package com.revature.services;

import com.revature.daos.AccountsDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Account;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountsDAO accountsDAO;
    private UsersDAO usersDAO;

    @Autowired
    public AccountService(AccountsDAO accountsDAO, UsersDAO usersDAO) {
        this.usersDAO= usersDAO;
        this.accountsDAO = accountsDAO;
    }


    public Optional<Account> getAccountById(int id){
        return accountsDAO.findById(id);
    }

    public Optional<List<Account>> getAccountOfUser(int userId){
        User user= usersDAO.findById(userId).get();
        return accountsDAO.findByUser(user);
    };

    public double getAmountOfAccount(int id){
        Account account = accountsDAO.findById(id).get();
        return account.getAmount();
    }

}