package com.revature.services;

import com.revature.daos.AccountTypeDAO;
import com.revature.models.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountsTypeService {
    private AccountTypeDAO accountTypeDAO;
    @Autowired
    public AccountsTypeService(AccountTypeDAO accountsDAO) {
        this.accountTypeDAO = accountsDAO;
    }

    public AccountType getAccountType(int id){
        return accountTypeDAO.findById(id).get();
    }
}
