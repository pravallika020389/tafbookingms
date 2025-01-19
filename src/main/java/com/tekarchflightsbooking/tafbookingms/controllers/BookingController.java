package com.tekarchflightsbooking.tafbookingms.controllers;



import com.tekarchflightsbooking.tafbookingms.models.BookingsDTO;
import com.tekarchflightsbooking.tafbookingms.service.BookingServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingServiceImp bookingService;


    @PostMapping
    public ResponseEntity<Object> addBooking(@RequestBody BookingsDTO booking) {
        return bookingService.addBooking(booking);
    }

}


