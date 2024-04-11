package com.ani.backend.controllers;
import com.ani.backend.dao.bookingModel;
//import com.ani.backend.response.ServiceResponse;
import com.ani.backend.service.bookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
//@RequestMapping("/test")
public class bookingController {

    @Autowired
    public bookingServices bookingservices;

    @PostMapping("/addBooking")
    public bookingModel addBooking(@RequestBody bookingModel bookingmodel) {
        return bookingservices.creatbookingmodel(bookingmodel);
    }

    @PostMapping("/addBookings")
    public List<bookingModel> addBookings(@RequestBody List<bookingModel> listofbookingmodels) {
        return bookingservices.creatbookingmodel(listofbookingmodels);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<bookingModel> getBookingById(@PathVariable int id) {
        try {
            bookingModel booking = bookingservices.getbookingModelById(id);// throws NoSuchElementException if not found

            if (booking == null) { // No Booking with the given id exists
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(booking);// return the found item
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // A unexpected error ocurred in
                                                                                    // server so service
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return a 404 error if something else goes wrong
        }

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<bookingModel>> findBookingsByUserId(@PathVariable int userId) {
        try {
            List<bookingModel> bookings = bookingservices.findBookingsByUserId(userId);

            if (bookings == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(bookings);
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }

    // @GetMapping("/booking/{id}")
    // public bookingModel getBookingById (@PathVariable int id ){
    // return bookingservices.getbookingModelById(id);
    // }
    @GetMapping("/bookings")
    public List<bookingModel> getAllbookings() {
        return bookingservices.getbookings();
    }

    @PutMapping("/updateBooking")
    public bookingModel updatbookingModel(@RequestBody bookingModel updatedbookingmodel) {
        return bookingservices.updatebookingModel(updatedbookingmodel);
    }

    // add delete method Booking by Id

    @DeleteMapping("cancelBooking/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable int id) {
        try {
            return ResponseEntity.ok(bookingservices.cancelbookingModelById(id));
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                // Log the exception here
                e.printStackTrace();
                // Return a 404 Not Found response
                return ResponseEntity.notFound().build();
            } else {
                // Log the exception here
                e.printStackTrace();
                // Return a generic error message
                throw new RuntimeException("An error occurred while deleting the booking.");
            }
        }
    }
}

