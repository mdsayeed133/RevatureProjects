package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.InnerTransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Finished code for transfer log lookup
public interface InnerTransferLogDAO extends JpaRepository<InnerTransferLog, Integer> {

    public Optional<List<InnerTransferLog>> findByToAccountIdOrFromAccountId(Account toUserAccountId, Account fromAccountId);
}
