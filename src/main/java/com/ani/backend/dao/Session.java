package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Session {
 
    @Id
    @Column(name="session_id")
    private String sessionId;

    @Column(name="user_id")
    private String userId;
}
