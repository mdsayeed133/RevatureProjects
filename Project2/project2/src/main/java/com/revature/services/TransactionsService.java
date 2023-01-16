package com.revature.services;


import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.models.TransactionDTO;
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

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        int accountId= transaction.getTargetAccountId();

        if(transaction.getAmount()==0)
            throw new Exception("Transactions of 0 dollars are not allowed.");

        String type = (transaction.getAmount() > 0)? "income":"expense";

        double amount= accountService.getAmountOfAccount(accountId);

        Account targetAccount = accountService.getAccountById(accountId).get();
        if(targetAccount==null)
            throw new Exception("Transaction failed, not an account.");
        TransactionType transactionType =new TransactionType((type.equalsIgnoreCase("expense")? 1:2),type);
        Transaction newTransaction = new Transaction(targetAccount,transaction.getAmount(),transaction.getMsg(),transactionType);
        //newTransaction.setAccount(targetAccount);
       // newTransaction.setDescription(transaction.getMsg());
       // newTransaction.setAmount(transaction.getAmount());
       // newTransaction.setType(new TransactionType((type.equalsIgnoreCase("expense")? 1:2),type));

        if(type==transactionTypeService.getTransactionTypeById(1).getTransactionTypesName()){//expense
            amount -= transaction.getAmount();
        } else {
            amount += transaction.getAmount();
        }
        targetAccount.setAmount(amount);
        accountsDAO.save(targetAccount);
        transactionsDAO.save(newTransaction);
        //if(accountsDAO.save(targetAccount)!=targetAccount) throw new Exception("Failed to update account's amount");
        return newTransaction;
    }

}
