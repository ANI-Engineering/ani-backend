package com.ani.backend.repositories;

import com.ani.backend.dao.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBuildingRepository extends JpaRepository<Building, Integer> {

    @Query(value = "SELECT b.building_id,b.location,b.building_name,b.address, \n" +
            "b.city,b.state,b.pincode, \n" +
            "b.nearby_attractions from building b join property p \n" +
            "on b.building_id=p.building_id where p.property_id = :propertyId",
            nativeQuery = true
    )
    Building findByPropertyId(Integer propertyId);
}
