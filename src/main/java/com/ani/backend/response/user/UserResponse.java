package com.ani.backend.response.user;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;

    private String email;

    private Integer phoneNumber;

    private String userType;
}
