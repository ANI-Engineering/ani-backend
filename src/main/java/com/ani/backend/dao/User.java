package com.ani.backend.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="email_id")
    private String email;
    @Column(name="user_type")
    private String userType;
    @Column(name="contact_country_code")
    private Integer contactCountryCode;
    @Column(name="contact_number")
    private Integer phoneNumber;
    @Column(name="alternate_contact_country_code")
    private Integer altContactCountryCode;
    @Column(name="alternate_contact_number")
    private Integer altPhoneNumber;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="date_of_birth")
    private Date dob;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="otp")
    private String otp;
    @Column(name= "otp_expiry")
    private LocalDateTime otpExpiry;
    @Column(name="state")
    private String state;
    @Column(name="user_creation_date")
    private Date userCreationDate;
    @Column(name="user_status")
    private String userStatus;

    @ElementCollection
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<UserPermission> userPermissions;
}


