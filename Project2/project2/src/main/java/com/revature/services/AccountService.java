package com.revature.services;

import com.revature.daos.AccountsDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountsDAO accountsDAO;
    private UsersDAO usersDAO;
    private AccountsTypeService accountsTypeService;

    @Autowired
    public AccountService(AccountsDAO accountsDAO, UsersDAO usersDAO, AccountsTypeService accountsTypeService) {
        this.usersDAO= usersDAO;
        this.accountsDAO = accountsDAO;
        this.accountsTypeService=accountsTypeService;
    }

    public Optional<Account> getAccountById(int id){
        return accountsDAO.findById(id);
    }

    public Optional<List<Account>> getAccountOfUser(int userId){
        User user= usersDAO.findById(userId).get();
        return accountsDAO.findByUser(user);
    }
    public Optional<List<Account>> getAccountOfUserAndType(int userId, int type){
        AccountType accountType= accountsTypeService.getAccountType(type);
        User user= usersDAO.findById(userId).get();
        return accountsDAO.findByUserAndAccountType(user,accountType);
    }
    @Transactional
    public double getAmountOfAccount(int id){
        Account account = accountsDAO.findById(id).get();
        return account.getAmount();
    }

}