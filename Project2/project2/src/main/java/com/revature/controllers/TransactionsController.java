package com.revature.controllers;

import com.revature.daos.TransactionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class TransactionsController {
    TransactionsDAO transactionsDAO;
    @Autowired
    public TransactionsController(TransactionsDAO transactionsDAO) {
        this.transactionsDAO = transactionsDAO;
    }
}
