package com.cursed.Cursed.repository;

import com.cursed.Cursed.models.User_2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User_2, Long> {
    Optional<User_2> findByEmail(String email);
}
