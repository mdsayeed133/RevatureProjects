package com.revature.daos;

import com.revature.models.Request;
import com.revature.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersDAO extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET first_name = ?2 WHERE id = ?1", nativeQuery = true)
    boolean updateUserFirstName(int id, String firstName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET last_name = ?2 WHERE id = ?1", nativeQuery = true)
    boolean updateUserLastName(int id, String lastName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = ?2 WHERE id = ?1", nativeQuery = true)
    boolean updateUserPassword(int id, String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET address = ?2 WHERE id = ?1", nativeQuery = true)
    boolean updateUserAddress(int id, String address);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET email = ?2 WHERE id = ?1", nativeQuery = true)
    boolean updateUserEmail(int id, String email);

    public Optional<User> findByUsernameAndPassword(String user_name, String password);
}
