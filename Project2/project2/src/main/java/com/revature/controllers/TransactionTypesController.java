package com.revature.controllers;

import com.revature.daos.TransactionTypesDAO;
import com.revature.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//we do not need this class
@RestController
@CrossOrigin
@RequestMapping()// TODO
public class TransactionTypesController {
    private TransactionTypesDAO transactionTypesDAO;

    @Autowired
    public TransactionTypesController(TransactionTypesDAO transactionTypesDAO) {
        this.transactionTypesDAO = transactionTypesDAO;
    }


}
