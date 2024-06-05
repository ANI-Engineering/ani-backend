package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "property_review")
@Data
public class PropertyReview {

    @Id
    @Column(name = "property_review_id")
    private int propertyReviewId;

    @Column(name = "property_id")
    private int propertyId;

    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "date_created")
    private LocalDateTime date_created;

    @Column(name = "property_reviewcol")
    private Integer propertyReviewcol;
}
