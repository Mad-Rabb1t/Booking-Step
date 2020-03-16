package app.dao;

import app.entity.Flight;
import app.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
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
        List<Flight> flights= daoFlights.flights;
        assertEquals(daoFlights.getAll(), flights);
    }

    @Test
    void getAllBy() {

    }

    @Test
    void create() {
        Flight flight = new Flight(20, "Baku", null, 25);
        daoFlights.create(flight);
        daoFlights.flights.get(10);
        assertEquals(flight, daoFlights.flights.get(10));
    }

    @Test
    void delete() {
        Flight flight = new Flight(11, "Baku", null, 25);
        daoFlights.create(flight);
        daoFlights.delete(10);
       assertEquals(daoFlights.flights.get(9), flight);
    }

    @Test
    void read() {

    }
}