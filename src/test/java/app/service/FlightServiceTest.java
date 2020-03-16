package app.service;

import app.entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
    FlightService flightService;

    @BeforeEach
    public void initialize() throws IOException {
        this.flightService = new FlightService();
    }


    @Test
    void getAllFlights() {
        List<Flight> flights1 = flightService.getAllFlights();
        List<Flight> flights2 = (List<Flight>) flightService.flight.getAll();
        assertEquals(flights1, flights2);
    }

    @Test
    void getFlights24H() {
    }

    @Test
    void getFlightBy() {
    }

    @Test
    void getFlightsBy() {
    }

    @Test
    void occupySeats() {
    }
}