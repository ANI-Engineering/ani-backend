package com.ani.backend.repositories;

import com.ani.backend.dao.Property;
import com.ani.backend.response.property.PropertyResponse;
import com.ani.backend.response.property.PropertyThumbnailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IPropertyRepository extends JpaRepository<Property, Integer> {

    @Query(value = "SELECT \n" +
            "p.property_id as propertyId, \n" +
            "p.property_type as propertyType, \n" +
            "b.building_name as buildingName , \n" +
            "b.location , \n" +
            "pp.property_price as price , \n" +
            "pr.rating as rating,\n" +
            "pi2.image_url as thumbnailImageUrl\n" +
            "FROM anidb.property p \n" +
            "JOIN building b \n" +
            "on b.building_id = p.building_id \n" +
            "JOIN property_image pi2 \n" +
            "on p.property_id = pi2.property_id \n" +
            "join property_price pp \n" +
            "on pp.property_id = p.property_id \n" +
            "join property_review pr \n" +
            "on pr.property_id = p.property_id\n" +
            "where pi2.image_type = 'thumbnail';",
            countQuery = "SELECT COUNT(*) FROM PROPERTY",
            nativeQuery = true
    )
    Page<PropertyThumbnailResponse> findAllPropertiesThumbnailPaginated(Pageable pageable);

    @Query(value = "SELECT \n" +
            "p.property_id as propertyId, \n" +
            "p.property_type as propertyType, \n" +
            "b.building_name as buildingName , \n" +
            "b.location , \n" +
            "pp.property_price as price , \n" +
            "pr.rating as rating,\n" +
            "pi2.image_url as thumbnailImageUrl\n" +
            "FROM anidb.property p \n" +
            "JOIN building b \n" +
            "on b.building_id = p.building_id \n" +
            "JOIN property_image pi2 \n" +
            "on p.property_id = pi2.property_id \n" +
            "join property_price pp \n" +
            "on pp.property_id = p.property_id \n" +
            "join property_review pr \n" +
            "on pr.property_id = p.property_id\n" +
            "left join booking b2\n" +
            "on b2.property_id = p.property_id \n" +
            "AND NOT (b2.check_in_date  <= :endDate AND b2.check_out_date >= :startDate)\n" +
            "where pi2.image_type = 'thumbnail';",
            countQuery = "SELECT COUNT(*) FROM PROPERTY",
            nativeQuery = true
    )
    Page<PropertyThumbnailResponse> findAllPropertiesThumbnailPaginatedWithDates(Pageable pageable, LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT \n" +
            "p.property_id as propertyId, \n" +
            "p.property_type as propertyType, \n" +
            "b.building_name as buildingName , \n" +
            "b.location , \n" +
            "pp.property_price as price , \n" +
            "pr.rating as rating,\n" +
            "pi2.image_url as thumbnailImageUrl\n" +
            "FROM anidb.property p \n" +
            "JOIN building b \n" +
            "on b.building_id = p.building_id \n" +
            "JOIN property_image pi2 \n" +
            "on p.property_id = pi2.property_id \n" +
            "join property_price pp \n" +
            "on pp.property_id = p.property_id \n" +
            "join property_review pr \n" +
            "on pr.property_id = p.property_id\n" +
            "where pi2.image_type = 'thumbnail' and b.location = :location;",
            countQuery = "SELECT COUNT(*) FROM PROPERTY",
            nativeQuery = true
    )
    Page<PropertyThumbnailResponse> findAllPropertiesThumbnailPaginated(Pageable pageable, String location);


    @Query(value = "SELECT \n" +
            "p.property_id as propertyId, \n" +
            "p.property_type as propertyType, \n" +
            "b.building_name as buildingName , \n" +
            "b.location , \n" +
            "pp.property_price as price , \n" +
            "pr.rating as rating,\n" +
            "pi2.image_url as thumbnailImageUrl\n" +
            "FROM anidb.property p \n" +
            "JOIN building b \n" +
            "on b.building_id = p.building_id \n" +
            "JOIN property_image pi2 \n" +
            "on p.property_id = pi2.property_id \n" +
            "join property_price pp \n" +
            "on pp.property_id = p.property_id \n" +
            "join property_review pr \n" +
            "on pr.property_id = p.property_id\n" +
            "left join booking b2\n" +
            "on b2.property_id = p.property_id \n" +
            "AND NOT (b2.check_in_date  <= :endDate AND b2.check_out_date >= :startDate)\n" +
            "where pi2.image_type = 'thumbnail' and b.location = ':location';",
            countQuery = "SELECT COUNT(*) FROM PROPERTY",
            nativeQuery = true
    )
    Page<PropertyThumbnailResponse> findAllPropertiesThumbnailPaginatedWithDates(Pageable pageable, LocalDate startDate, LocalDate endDate, String location);

    @Query(value = "SELECT \n" +
            "p.property_id , \n" +
            "p.property_type , \n" +
            "b.building_name  , \n" +
            "b.location , \n" +
            "pp.property_price  , \n" +
            "pr.rating ,\n" +
            "pi2.image_url \n" +
            "FROM anidb.property p \n" +
            "JOIN building b \n" +
            "on b.building_id = p.building_id \n" +
            "JOIN property_image pi2 \n" +
            "on p.property_id = pi2.property_id \n" +
            "join property_price pp \n" +
            "on pp.property_id = p.property_id \n" +
            "join property_review pr \n" +
            "on pr.property_id = p.property_id\n" +
            "where p.property_id = ':id';",
            countQuery = "SELECT COUNT(*) FROM PROPERTY",
            nativeQuery = true
    )
    Property findAllProperties(int id);

}
