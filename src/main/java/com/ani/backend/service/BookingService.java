package com.ani.backend.service;

import com.ani.backend.dao.Booking;
import com.ani.backend.dao.Property;
import com.ani.backend.repositories.IBookingRepository;
import com.ani.backend.repositories.IPropertyRepository;
import com.ani.backend.request.booking.bookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private IBookingRepository bookingRepository;

    public Integer CreateBooking(bookingRequest bookingReqest) {
        return 1;
                //bookingRepository.AddBooking(bookingReqest);
    }
}
