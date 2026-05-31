package com.example.bookingsystem.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "event" , schema = "bookingsystem")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "totalcapacity")
    private Long totalCapacity;

    @Column(name = "leftcapacity")
    private Long leftCapacity;

    @ManyToOne
    @JoinColumn(name = "venueid")
    private VenueEntity venue;
}
