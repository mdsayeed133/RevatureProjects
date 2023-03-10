package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.Request;
import com.revature.models.Status;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestsDAO extends JpaRepository<Request, Integer> {
    public Optional <List<Request>> findByFromUserId(User fromUserId);
    public Optional <List<Request>> findByToUserId(User toUserId);
    public Optional <List<Request>> findByFromAccountId(Account fromAccountId);
    public Optional <List<Request>> findByToAccountId(Account toAccountId);
    public Optional <List<Request>> findByStatusId(Status statusId);
    public Optional <List<Request>> findByFromUserIdAndStatusId(User fromUserId, Status statusId);


}
