package com.revature.services;


import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.models.TransactionDTO;
import com.revature.models.TransactionType;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransactionsService {

    private TransactionsDAO transactionsDAO;
    private AccountService accountService;
    private TransactionTypeService transactionTypeService;
    private AccountsDAO accountsDAO;

    @Autowired
    public TransactionsService(TransactionsDAO transactionsDAO, AccountService accountService, TransactionTypeService transactionTypeService, AccountsDAO accountsDAO) {
        this.transactionsDAO = transactionsDAO;
        this.accountsDAO = accountsDAO;
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
        Account targetAccount = accountService.getAccountById(accountId).get();
        String type= transaction.getType().getTransactionTypesName();
        double amount= accountService.getAmountOfAccount(accountId);

        if(type==transactionTypeService.getTransactionTypeById(1).getTransactionTypesName()){//expense
            amount -= transaction.getAmount();
        } else {
            amount += transaction.getAmount();
        }
        targetAccount.setAmount(amount);
        accountsDAO.save(targetAccount);
        return transactionsDAO.save(transaction);
    }

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        int accountId= transaction.getTargetAccountId();

        if(transaction.getAmount()==0)
            throw new Exception("Transactions of 0 dollars are not allowed.");

        String type = (transaction.getAmount() > 0)? "income":"expense";

        double amount= accountService.getAmountOfAccount(accountId);
        amount += transaction.getAmount();
        amount = DoubleRounder.round(amount,2);
        Account targetAccount = accountService.getAccountById(accountId).get();
        if(targetAccount==null)
            throw new Exception("Transaction failed, not an account.");

        TransactionType transactionType;
        if(type==transactionTypeService.getTransactionTypeById(1).getTransactionTypesName()){//expense
            transactionType = transactionTypeService.getTransactionTypeById(1);
        } else {
            transactionType = transactionTypeService.getTransactionTypeById(2);
        }

        Transaction newTransaction = new Transaction(targetAccount,transaction.getAmount(),transaction.getMsg(),transactionType);

        targetAccount.setAmount(amount);
        accountsDAO.save(targetAccount);
        transactionsDAO.save(newTransaction);
        return newTransaction;
    }

}
