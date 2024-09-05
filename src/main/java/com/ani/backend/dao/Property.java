
package com.ani.backend.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "property")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Integer propertyId;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "balcony")
    private Integer balcony;

    @Column(name = "bathrooms")
    private Integer bathrooms;

    @Column(name = "bedrooms")
    private Integer bedrooms;

    @Column(name = "description")
    private String description;

    @Transient
    private String location;

    @Transient
    private String nearByLocation;

    @Column(name = "flat_no")
    private String flatNo;

    @Column(name = "kitchen")
    private Integer kitchen;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "title")
    private String title;

    @Column(name = "building_id")
    private Integer buildingId;

    @Column(name="max_guest_allowes")
    private String maxGuestAllowed;

    @Column(name="metadata")
    private String metadata;

    @Transient
    private List<String> imageurls;

    @Transient
    private Double averageRating;
}
