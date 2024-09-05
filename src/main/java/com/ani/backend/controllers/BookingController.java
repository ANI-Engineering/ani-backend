package com.ani.backend.controllers;

import com.ani.backend.dao.Booking;
import com.ani.backend.response.booking.BookingResponse;

import com.ani.backend.request.booking.bookingRequest;
import com.ani.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookProperty")
    public ResponseEntity<Integer> getPropertyById(@RequestBody bookingRequest bookingReqest) {
        Integer bookingResponse = bookingService.CreateBooking(bookingReqest);
        if (bookingResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookingResponse);
    }
}
