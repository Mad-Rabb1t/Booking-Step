package app.service;

import app.entity.Flight;
import app.entity.Predicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        ArrayList<Flight> expected = new ArrayList<>();
        expected.add(flightService.getFlightBy(Predicates.flightsById(9)));
        expected.add(flightService.getFlightBy(Predicates.flightsById(15)));
        expected.add(flightService.getFlightBy(Predicates.flightsById(26)));
        assertEquals(expected, flightService.getFlights24H());
    }

    @Test
    void getFlightsBy() {
        ArrayList<Flight> expected = new ArrayList<>();
        expected.add(flightService.getFlightBy(Predicates.flightsById(8)));
        expected.add(flightService.getFlightBy(Predicates.flightsById(9)));
        assertEquals(expected, flightService.getFlightsBy("Baku",LocalDate.parse("18/03/2020",
                DateTimeFormatter.ofPattern("dd/MM/yyyy")), 20));
        expected.remove(0);
        assertEquals(expected, flightService.getFlightsBy("baku",LocalDate.parse("18/03/2020",
                DateTimeFormatter.ofPattern("dd/MM/yyyy")), 80));
    }

    @Test
    void occupySeats() {
        flightService.occupySeats(2, 1);
        int actual = flightService.getAllFlights().get(0).getFreeSpaces();
        assertEquals(60, actual);
    }
}