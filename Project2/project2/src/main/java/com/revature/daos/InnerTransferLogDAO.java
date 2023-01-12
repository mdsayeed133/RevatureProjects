package com.revature.daos;

import com.revature.models.InnerTransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerTransferLogDAO extends JpaRepository<InnerTransferLog, Integer> {
}
