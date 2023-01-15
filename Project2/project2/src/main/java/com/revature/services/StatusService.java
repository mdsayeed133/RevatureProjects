package com.revature.services;

import com.revature.models.Status;
import com.revature.daos.StatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private StatusDAO statusDAO;

    @Autowired
    public StatusService(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    public Status getStatusById(int id) {
        Optional<Status> optionalStatus= statusDAO.findById(id);
        return optionalStatus.get();
    }


}
