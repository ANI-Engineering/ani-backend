package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "building")
public class Building {

    @Id
    @Column(name = "building_id")
    private Integer buildingId;

    @Column(name = "location")
    private String location;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "nearby_attractions")
    private String nearby_attractions;
}