package com.ani.backend.response.property;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PropertyResponse {

    private String title;
    private String propertyType;
    private String location;
    private String description;
    private List<String> nearByLocation;
    private Double rating;
    private List<String> imageUrls;
    public PropertyResponse(String title, String propertyType, String location, String description,
                       String nearByLocation, Double rating, List<String> imageUrls) {
        this.title = title;
        this.propertyType = propertyType;
        this.location = location;
        this.description = description;
        this.nearByLocation = Collections.singletonList(nearByLocation);
        this.rating = rating;
        this.imageUrls = imageUrls;
    }
}
