package com.ani.backend.service;

import com.ani.backend.dao.Property;
import com.ani.backend.dao.PropertyImage;
import com.ani.backend.dao.PropertyReview;
import com.ani.backend.repositories.IPropertyRepository;
import com.ani.backend.repositories.PropertyImageRepository;
import com.ani.backend.repositories.PropertyReviewRepository;
import com.ani.backend.response.property.PropertyResponse;
import com.ani.backend.response.property.PropertyThumbnailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private PropertyImageRepository propertyImageRepository;

    @Autowired
    private PropertyReviewRepository propertyReviewRepository;

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    public Page<Property> getAllPropertiesPaginated(int page, int size){
        return propertyRepository.findAll(PageRequest.of(page, size));
    }

    public Page<PropertyThumbnailResponse> getPropertiesThumbnailPaginated(int page, int size, String location, LocalDate startDate, LocalDate endDate){

        if(null == startDate || null == endDate) {
            if(null != location){
                return propertyRepository.findAllPropertiesThumbnailPaginated(PageRequest.of(page, size), location);
            }else{
                return propertyRepository.findAllPropertiesThumbnailPaginated(PageRequest.of(page, size));
            }

        } else {
            if(null != location){
                return propertyRepository.findAllPropertiesThumbnailPaginatedWithDates(PageRequest.of(page, size),startDate, endDate, location);
            }else{
                return propertyRepository.findAllPropertiesThumbnailPaginatedWithDates(PageRequest.of(page, size),startDate, endDate);
            }
        }
    }
    public PropertyResponse getPropertyDetailsById(Integer id) {
        
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return null;
        }

        List<String> imageUrls = propertyImageRepository.findByPropertyId(id).stream()
                .map(PropertyImage::getImageUrl)
                .collect(Collectors.toList());

        Double averageRating = propertyReviewRepository.findByPropertyId(id).stream()
                .mapToDouble(PropertyReview::getRating)
                .average()
                .orElse(0.0);

        return new PropertyResponse(
                property.getTitle(),
                property.getPropertyType(),
                property.getLocation(),
                property.getDescription(),
                property.getNearByLocation(),
                averageRating,
                imageUrls);
    }
    
}
