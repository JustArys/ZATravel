package com.example.zatravel.User;

import com.example.zatravel.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findBYEmail(String email);
}
