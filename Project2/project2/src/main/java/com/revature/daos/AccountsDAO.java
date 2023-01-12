package com.revature.daos;

import com.revature.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsDAO extends JpaRepository<Account,Integer> {

}