package com.revature.daos;

import com.revature.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypesDAO extends JpaRepository<TransactionType,Integer> {
    //no additional functionality needs to be described here.
}
