package com.revature.daos;

import com.revature.models.Request;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestsDAO extends JpaRepository<Request, Integer> {
    public Optional <List<Request>> findByFromUserId(int fromUserId);
    public Optional <List<Request>> findByToUserId(int toUserId);
    public Optional <List<Request>> findByFromAccountId(int fromAccountId);
    public Optional <List<Request>> findByToAccountId(int toAccountId);
    public Optional <List<Request>> findByStatusId(int statusId);
    public Optional <List<Request>> findByToUserIdAndStatusId(int toUserId, int statusId);

    @Modifying
    @Transactional
    @Query(value="Update requests set status_id = ?2 where request_id = ?1", nativeQuery = true)
    boolean updateStatus(int requestId, int statusId);
}
