package com.example.bookingsystem.response;


import com.example.bookingsystem.entity.VenueEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {

    private Long eventId;
    private String eventName;
    private Long capacity;
    private VenueEntity venueEntity;
    private BigDecimal ticketPrice;

}
