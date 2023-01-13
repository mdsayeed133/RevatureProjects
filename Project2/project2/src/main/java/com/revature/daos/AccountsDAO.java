package com.revature.daos;

import com.revature.models.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsDAO extends JpaRepository<Account,Integer> {
    @Modifying
    @Transactional
    @Query(value="Update accounts set amount = ?2, where id = ?1", nativeQuery = true)
    boolean updateAmount(int id, double amount);
}
