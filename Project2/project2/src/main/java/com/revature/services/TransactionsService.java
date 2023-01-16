package com.revature.services;


import com.revature.models.Transaction;
import com.revature.daos.TransactionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
