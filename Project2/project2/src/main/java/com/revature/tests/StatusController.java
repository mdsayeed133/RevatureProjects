package com.revature.tests;

import com.revature.daos.StatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class StatusController {
    private StatusDAO sDAO;
    @Autowired
    public StatusController(StatusDAO sDAO) {
        this.sDAO = sDAO;
    }
}
