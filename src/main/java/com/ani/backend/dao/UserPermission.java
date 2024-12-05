package com.ani.backend.dao;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class UserPermission {

    private String resource;

    @Enumerated(EnumType.STRING)
    private UserAction action;
}