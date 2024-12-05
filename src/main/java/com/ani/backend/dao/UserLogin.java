package com.ani.backend.dao;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserLogin {
    @Id
    @Column(name="email_id")
    private String email;

    @Column(name="otp")
    private String otp;
    
    @Column(name="otp_expiry")
    private LocalDateTime otpExpiry;
}
