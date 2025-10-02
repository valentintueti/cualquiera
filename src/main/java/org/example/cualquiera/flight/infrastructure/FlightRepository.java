package org.example.cualquiera.flight.infrastructure;

import org.example.cualquiera.flight.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    boolean existsByFlightNumber(String flightNumber);
}
