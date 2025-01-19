package com.tekarchflightsbooking.tafbookingms.service.interfaces;

import com.tekarchflightsbooking.tafbookingms.models.BookingsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface BookingService {
    ResponseEntity<Object> addBooking(BookingsDTO booking);
}
