package com.example.bookingsystem.controller;

import com.example.bookingsystem.response.EventInventoryResponse;
import com.example.bookingsystem.response.VenueInventoryResponse;
import com.example.bookingsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory/events")

    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){

        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryByVenueId (@PathVariable("venueId") Long venueId){

        return inventoryService.getVenueInformation(venueId);
    }

}
