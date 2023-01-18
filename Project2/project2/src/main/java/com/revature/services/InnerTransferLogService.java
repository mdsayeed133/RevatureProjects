package com.revature.services;

import com.revature.daos.InnerTransferLogDAO;
import com.revature.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InnerTransferLogService {
    private InnerTransferLogDAO innerTransferLogDAO;
    private AccountService accountService;
    private TransactionsService transactionsService;


    @Autowired
    public InnerTransferLogService(InnerTransferLogDAO innerTransferLogDAO, AccountService accountService, TransactionsService transactionsService) {
        this.innerTransferLogDAO = innerTransferLogDAO;
        this.accountService = accountService;
        this.transactionsService= transactionsService;
    }

    public Optional<List<InnerTransferLog>> findByAccountId(int accountId) {
        Account account = accountService.getAccountById(accountId).get();
        return innerTransferLogDAO.findByToAccountIdOrFromAccountId(account, account);
    }
    @Transactional
    public InnerTransferLog doTransfer(InnerTransferLogDTO transferLogDTO) throws Exception{
        if(transferLogDTO.getFromAccountId()==transferLogDTO.getToAccountId()) throw new Exception("can't money to itself");
        if(transferLogDTO.getAmount()<=0) throw new Exception("amount must be positive");

        Account fromAccount= accountService.getAccountById(transferLogDTO.getFromAccountId()).get();
        User fromUser = fromAccount.getUser();
        Account toAccount = accountService.getAccountById(transferLogDTO.getToAccountId()).get();
        User toUser = toAccount.getUser();

        //take money form account
        String fromMsg = "Sent money to "+toUser.getFirstName()+" "+toUser.getLastName()+"["+toUser.getUsername()+"] at Account#:"+toAccount.getAccountId();
        TransactionDTO fromDto = new TransactionDTO(fromAccount.getAccountId(),fromMsg,-transferLogDTO.getAmount());
        transactionsService.createTransaction(fromDto);

        //give money to account
        String toMsg = "Received money from "+fromUser.getFirstName()+" "+fromUser.getLastName()+"["+fromUser.getUsername()+"] with Account#:"+fromAccount.getAccountId();
        TransactionDTO toDto = new TransactionDTO(toAccount.getAccountId(),toMsg,transferLogDTO.getAmount());
        transactionsService.createTransaction(toDto);

        //create and save the transfer log
        InnerTransferLog transferLog = new InnerTransferLog(fromAccount,toAccount,transferLogDTO.getAmount());
        innerTransferLogDAO.save(transferLog);

        return transferLog;
    }

}


