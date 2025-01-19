package com.tekarchflightsbooking.tafbookingms.service;


import com.tekarchflightsbooking.tafbookingms.models.BookingsDTO;
import com.tekarchflightsbooking.tafbookingms.models.FlightsDTO;
import com.tekarchflightsbooking.tafbookingms.models.UsersDTO;
import com.tekarchflightsbooking.tafbookingms.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.booking.service.url}")
    private String dataStore_Booking_Url;

    @Value("${datastore.user.service.url}")
    private String dataStore_User_Url;

    @Value("${datastore.flight.service.url}")
    private String dataStore_Flight_Url;


    public ResponseEntity<Object> addBooking(BookingsDTO booking) {

        UsersDTO user = restTemplate.getForObject(dataStore_User_Url + booking.getUsers().getId(), UsersDTO.class);
        FlightsDTO flight = restTemplate.getForObject(dataStore_Flight_Url + booking.getFlights().getId(), FlightsDTO.class);

        if (user != null && flight != null) {
            BookingsDTO receivedBooking =restTemplate.postForObject(dataStore_Booking_Url + "add" , booking , BookingsDTO.class);
            return ResponseEntity.ok(receivedBooking);
        } else if(user == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found " + booking.getUsers().getId());
        }
        else if(flight == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found " + booking.getFlights().getId());
        }

        //return restTemplate.postForObject(dataStore_Booking_Url + "add" , booking , BookingsDTO.class);
    }
}
