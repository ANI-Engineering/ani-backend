package com.ani.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.backend.dao.Session;

public interface SessionRepository extends JpaRepository<Session, String> {

}
