package com.ani.backend.request.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.core.util.Json;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class bookingRequest {
    @JsonProperty("BookingId")
    private Integer booking_id;
    @JsonProperty("BookingDate")
    private LocalDateTime booking_date;
    @JsonProperty("CheckInDate")
    private Date check_in_date;
    @JsonProperty("CheckOutDate")
    private Date check_out_date;
    @JsonProperty("PropertyId")
    private String property_id;
    @JsonProperty("Metadata")
    private String metadata;
    @JsonProperty("PurposeOfVisit")
    private String purpose_of_visit;
}
