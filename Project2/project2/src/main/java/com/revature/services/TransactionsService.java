package com.revature.services;


import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.daos.TransactionsDAO;
import com.revature.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransactionsService {

    private TransactionsDAO transactionsDAO;
    private AccountService accountService;
    private TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionsService(TransactionsDAO transactionsDAO, AccountService accountService, TransactionTypeService transactionTypeService) {
        this.transactionsDAO = transactionsDAO;
        this.accountService= accountService;
        this.transactionTypeService =transactionTypeService;
    }

    public Optional<List<Transaction>> getListOfTransactionByAccountId(int accountId){
        Account account = accountService.getAccountById(accountId).get();
        return transactionsDAO.findByAccount(account);
    }

    public Optional<List<Transaction>> getListOfTransactionByAccountIdAndTypeId(int accountId, int typeId){
        Account account = accountService.getAccountById(accountId).get();
        TransactionType type = transactionTypeService.getTransactionTypeById(typeId);
        return transactionsDAO.findByAccountAndType(account,type);
    }

    public Transaction createTransaction(Transaction transaction) throws Exception {
        int accountId= transaction.getAccount().getAccountId();
        String type= transaction.getType().getTransactionTypesName();
        double amount= accountService.getAmountOfAccount(accountId);

        if(type==transactionTypeService.getTransactionTypeById(1).getTransactionTypesName()){//expense
            amount -= transaction.getAmount();
        } else {
            amount += transaction.getAmount();
        }
        if(!accountService.updateAmount(accountId,amount)) throw new Exception("Failed to account's amount");
        return transactionsDAO.save(transaction);
    }

}
