package com.revature.daos;

import com.revature.models.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Finished.
public interface AccountsDAO extends JpaRepository<Account,Integer> {
    @Modifying
    @Transactional
    @Query(value="Update accounts set amount = ?2, where id = ?1", nativeQuery = true)
    boolean updateAmount(int id, double amount);

    Optional<List<Account>> findByUser(int userId);
}
