package com.revature.daos;

import com.revature.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //no additional functionality needs to be described here.
public interface AccountTypeDAO extends JpaRepository<AccountType, Integer> {

}
