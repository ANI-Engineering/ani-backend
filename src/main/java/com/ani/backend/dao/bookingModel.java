package com.ani.backend.dao;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookingModel {
    @Id
    @GeneratedValue
    @Column
    private int bookingID;
    @Column
    private int userId;
    @Column
    private String status;
    @Column
    private int propertyId;
    @Column
    private int adultCount;
    @Column
    private int childCount;
    @Column
    private int infantCount;
    @Column
    private LocalDate bookingDate;
    @Column
    private LocalDate  checkInDate;
    @Column
    private LocalDate checkOutDate; 
   
}
