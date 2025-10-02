package org.example.cualquiera.flight.application;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cualquiera.flight.domain.FlightService;
import org.example.cualquiera.flight.dto.NewFlightRequestDTO;
import org.example.cualquiera.flight.dto.NewIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<NewIdDTO> create(@RequestBody @Valid NewFlightRequestDTO newFlightRequestDTO) {
        
    }
}
