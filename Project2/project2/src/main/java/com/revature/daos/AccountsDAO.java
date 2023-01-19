package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsDAO extends JpaRepository<Account,Integer> {

    Optional<List<Account>> findByUser(User userId);
    Optional<List<Account>> findByUserAndAccountType(User userId, AccountType accountType);
}
