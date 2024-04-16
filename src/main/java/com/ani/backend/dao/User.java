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

    private String userType;
    @Column(name="contact_country_code")
    private Integer contact_country_code;
    @Column(name="contact_number")
    private Integer phone_number;
    @Column(name="alternate_contact_country_code")
    private Integer alt_contact_country_code;
    @Column(name="alternate_contact_number")
    private Integer alt_phone_number;
    @Column(name="last_name")
    private String last_name;
    @Column(name="first_name")
    private String first_name;
    @Column(name="date_of_birth")
    private Date dob;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="user_creation_date")
    private Date user_creation_date;
    @Column(name="user_status")
    private String user_status;

    @ElementCollection
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<UserPermission> userPermissions;
}


