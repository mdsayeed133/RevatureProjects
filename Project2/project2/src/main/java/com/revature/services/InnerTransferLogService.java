package com.revature.services;

import com.revature.daos.InnerTransferLogDAO;
import com.revature.models.InnerTransferLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InnerTransferLogService {

    private InnerTransferLogDAO innerTransferLogDAO;

    @Autowired
    public InnerTransferLogService(InnerTransferLogDAO innerTransferLogDAO) {
        this.innerTransferLogDAO = innerTransferLogDAO;
    }

    public Optional<List<InnerTransferLog>> findByAccountId(int AccountId) {
        return innerTransferLogDAO.findByToAccountIdOrFromAccountId(AccountId, AccountId);
    }

}


