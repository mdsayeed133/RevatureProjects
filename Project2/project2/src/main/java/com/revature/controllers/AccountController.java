package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO: discuss endpoints
public class AccountController {
    private AccountsDAO aDAO;
    @Autowired
    public AccountController(AccountsDAO aDAO) {
        this.aDAO = aDAO;
    }
}
