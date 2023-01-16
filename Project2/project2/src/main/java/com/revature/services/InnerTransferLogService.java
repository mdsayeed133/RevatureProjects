package com.revature.services;

import com.revature.daos.InnerTransferLogDAO;
import com.revature.models.Account;
import com.revature.models.InnerTransferLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InnerTransferLogService {

    private InnerTransferLogDAO innerTransferLogDAO;
    private AccountService accountService;


    @Autowired
    public InnerTransferLogService(InnerTransferLogDAO innerTransferLogDAO, AccountService accountService) {
        this.innerTransferLogDAO = innerTransferLogDAO;
        this.accountService = accountService;
    }

    public Optional<List<InnerTransferLog>> findByAccountId(int accountId) {
        Account account = accountService.getAccountById(accountId).get();
        return innerTransferLogDAO.findByToAccountIdOrFromAccountId(account, account);
    }

}


