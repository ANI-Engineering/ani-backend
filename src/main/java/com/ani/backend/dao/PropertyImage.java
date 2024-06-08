package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "property_image")
@Data
public class PropertyImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_image_id")
    private int propertyImageId;

    @Column(name = "property_id")
    private int propertyId;

    @Column(name = "image_url",length = 2000)
    private String imageUrl;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_order")
    private String imageOrder;

    @Column(name = "category")
    private String category;
}
