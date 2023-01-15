package com.revature.controllers;

import com.revature.daos.AccountTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class AccountsTypeController {
    private AccountTypeDAO atDAO;
    @Autowired
    public AccountsTypeController(AccountTypeDAO atDAO) {
        this.atDAO = atDAO;
    }
}
