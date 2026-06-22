package com.example.bookingsystem.service;


import com.example.bookingsystem.entity.EventEntity;
import com.example.bookingsystem.entity.VenueEntity;
import com.example.bookingsystem.repository.EventRepository;
import com.example.bookingsystem.repository.VenueRepository;
import com.example.bookingsystem.response.EventInventoryResponse;
import com.example.bookingsystem.response.VenueInventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;


    public List<EventInventoryResponse> getAllEvents(){
        final List<EventEntity> events = eventRepository.findAll();

        return events.stream().map(eventEntity -> EventInventoryResponse.builder()
                .eventName(eventEntity.getName())
                .capacity(eventEntity.getLeftCapacity())
                .venueEntity(eventEntity.getVenue())
                .build()).collect(Collectors.toList());
    }

    public VenueInventoryResponse getVenueInformation(Long venueId){
        final VenueEntity venueEntity = venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));

        return VenueInventoryResponse.builder()
                .venueId(venueEntity.getId())
                .venueName(venueEntity.getName())
                .totalCapacity(venueEntity.getTotalCapacity())
                .build();
    }

    public EventInventoryResponse getEventInventory(final Long eventId){
        final EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(null);
        return EventInventoryResponse.builder()
                .eventName(eventEntity.getName())
                .capacity(eventEntity.getLeftCapacity())
                .ticketPrice(eventEntity.getTicketPrice())
                .venueEntity(eventEntity.getVenue())
                .eventId(eventEntity.getId())
                .build();
    }
}
