package org.example.cualquiera.flight.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Valid
@Getter
@Setter
public class NewFlightRequestDTO {
    @NotBlank
    public String airlineName;

    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]{1,6}$")
    public String flightNumber;

    @NotNull
    public Date estDepartureTime;

    @NotNull
    public Date estArrivalTime;

    @NotNull
    @Positive
    public Integer availableSeats;

    @AssertTrue
    public boolean isDepartureBeforeArrival() {
        if (estDepartureTime == null || estArrivalTime == null) {
            return true;
        }
        return estDepartureTime.before(estArrivalTime);
    }
}
