package com.tekarchflightsbooking.tafbookingms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDTO {

    private Long id;
    private UsersDTO users;
    private FlightsDTO flights;
    private String status; // e.g., Booked, Cancelled
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

