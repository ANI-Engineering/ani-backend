package com.ani.backend.repositories;

import com.ani.backend.dao.PropertyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyReviewRepository extends JpaRepository<PropertyReview, Integer> {
    List<PropertyReview> findByPropertyId(int propertyId);
}
