package com.revature.controllers;

import com.revature.daos.InnerTransferLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class InnerTransferLogController {
    private InnerTransferLogDAO itlDAO;

    @Autowired
    public InnerTransferLogController(InnerTransferLogDAO itlDAO) {
        this.itlDAO = itlDAO;
    }
}
