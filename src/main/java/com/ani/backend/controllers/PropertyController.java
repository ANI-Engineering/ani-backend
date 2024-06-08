package com.ani.backend.controllers;

import com.ani.backend.dao.Property;
import com.ani.backend.response.ServiceResponse;
import com.ani.backend.response.property.PropertyResponse;
import com.ani.backend.response.property.PropertyThumbnailResponse;
import com.ani.backend.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    private ServiceResponse<List<Property>> getAllProperties(){
        return ServiceResponse.<List<Property>>builder()
                .status(HttpStatus.OK.value())
                .payload(propertyService.getAllProperties())
                .build();
    }

    @GetMapping("/paginated")
    private ServiceResponse<Page<Property>> getAllPropertiesPaginated(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return ServiceResponse.<Page<Property>>builder()
                .status(HttpStatus.OK.value())
                .payload(propertyService.getAllPropertiesPaginated(page, size))
                .build();

    }

    @GetMapping("/thumbnail/paginated")
    private ServiceResponse<Page<PropertyThumbnailResponse>> getAllPropertiesThumbnailPaginated(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String location){
        return ServiceResponse.<Page<PropertyThumbnailResponse>>builder()
                .status(HttpStatus.OK.value())
                .payload(propertyService.getPropertiesThumbnailPaginated(page, size, location, startDate, endDate))
                .build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable Integer id) {
        PropertyResponse propertyResponse = propertyService.getPropertyDetailsById(id);
        if (propertyResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(propertyResponse);
    }
}
