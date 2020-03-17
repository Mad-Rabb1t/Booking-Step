package app.dao;

import app.entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DAOFlightsTest {
    DAOFlights daoFlights;

    @BeforeEach
    public void initialize() throws IOException {
        this.daoFlights = new DAOFlights();
    }

    @Test
    void get() {
        Optional<Flight> flight = Optional.of(daoFlights.flights.get(0));
        daoFlights.get(1);
        assertEquals(daoFlights.get(1), flight);
    }

    @Test
    void getAll() {
        daoFlights.getAll();
        List<Flight> flights = daoFlights.flights;
        assertEquals(daoFlights.getAll(), flights);
    }

    @Test
    void create() {
        Flight flight = new Flight(20, "Baku", null, 25);
        daoFlights.create(flight);
        assertEquals(flight, daoFlights.flights.get(30));
    }

    @Test
    void delete() {
        Flight flight = new Flight(31, "Baku", LocalDateTime.parse("03/04/2020 09:50",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), 25);
        daoFlights.create(flight);
        daoFlights.delete(29);
        assertEquals(flight, daoFlights.flights.get(29));
    }
}