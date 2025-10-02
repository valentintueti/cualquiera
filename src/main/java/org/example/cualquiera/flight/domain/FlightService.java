package org.example.cualquiera.flight.domain;

import lombok.RequiredArgsConstructor;
import org.example.cualquiera.flight.dto.NewFlightRequestDTO;
import org.example.cualquiera.flight.dto.NewIdDTO;
import org.example.cualquiera.flight.infrastructure.FlightRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public NewIdDTO createFlight(NewFlightRequestDTO newFlightRequestDTO) {
        String number = newFlightRequestDTO.flightNumber;
        if(flightRepository.existsByFlightNumber(number)) {
            throw new IllegalArgumentException("Flight number already exists");
        }

        Flight flight = new Flight();
        flight.setAirlineName(newFlightRequestDTO.airlineName);
        flight.setFlightNumber(newFlightRequestDTO.flightNumber);
        flight.setEstDepartureTime(newFlightRequestDTO.estDepartureTime);
        flight.setEstArrivalTime(newFlightRequestDTO.estArrivalTime);
        flight.setAvailableSeats(newFlightRequestDTO.availableSeats);
        Flight savedFlight = flightRepository.save(flight);

        return new NewIdDTO(savedFlight.getId());

    }
}
