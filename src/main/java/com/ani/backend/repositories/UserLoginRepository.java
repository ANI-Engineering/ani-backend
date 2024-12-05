package com.ani.backend.repositories;

import com.ani.backend.dao.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    Optional<UserLogin> findByEmail(String email);
}
