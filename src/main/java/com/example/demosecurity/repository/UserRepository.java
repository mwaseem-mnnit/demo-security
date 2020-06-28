package com.example.demosecurity.repository;

import com.example.demosecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mohd.waseem on 28/06/20.
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
