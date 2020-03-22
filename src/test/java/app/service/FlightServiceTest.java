package app.service;

import app.entity.Flight;
import app.entity.FlightPredicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Flight fl = new Flight(2020, "LA", LocalDateTime.now().plusHours(6), 100);
        flightService.getAllFlights().add(fl);
        assertTrue(flightService.getFlights24H().contains(fl));
        flightService.getAllFlights().remove(fl);
    }

    @Test
    void getFlightBy(){
        Flight fl = new Flight(2020, "LA", LocalDateTime.now().plusHours(6), 100);
        flightService.getAllFlights().add(fl);
        assertEquals(flightService.getFlightBy(FlightPredicates.flightsById(2020)), fl);
        assertEquals(flightService.getFlightBy(FlightPredicates.flightByInfo("LA",LocalDate.now(),2)), fl);
    }

    @Test
    void getFlightsBy() {
        ArrayList<Flight> expected = new ArrayList<>();
        expected.add(flightService.getFlightBy(FlightPredicates.flightsById(8)));
        expected.add(flightService.getFlightBy(FlightPredicates.flightsById(9)));
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