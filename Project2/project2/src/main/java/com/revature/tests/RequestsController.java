package com.revature.tests;

import com.revature.daos.RequestsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class RequestsController {
    private RequestsDAO rDAO;

    @Autowired
    public RequestsController(RequestsDAO rDAO) {
        this.rDAO = rDAO;
    }
}
