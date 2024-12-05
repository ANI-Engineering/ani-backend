package com.ani.backend.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;
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
    @Column(name="user_creation_date")
    private Date userCreationDate;
    @Column(name="user_status")
    private String userStatus;

    @ElementCollection
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<UserPermission> userPermissions;
}


