package org.example.cualquiera.flight.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String airlineName;

    @Column(nullable = false, unique = true)
    private String flightNumber;

    @Column(nullable = false)
    private Date estDepartureTime;

    @Column(nullable = false)
    private Date estArrivalTime;

    @Column(nullable = false)
    private Integer availableSeats;
}
