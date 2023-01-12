package com.revature.daos;

import com.revature.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsDAO extends JpaRepository<Request, Integer> {
}
