package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDAO extends JpaRepository<User, Integer> {

    public Optional<User> findByUsernameAndPassword(String user_name, String password);
}
