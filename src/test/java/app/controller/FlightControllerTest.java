package app.controller;

import app.entity.Flight;
import app.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
    private FlightController controller;

    @BeforeEach
    public void initialize() {
        this.controller = new FlightController();
    }


    @Test
    void makeReservation() {
        controller.makeReservation(2, 1);
        int x = controller.service.getAllFlights().get(0).getFreeSpaces();
        assertEquals(x, 105);
    }

    @Test
    void removeReservation() {
        controller.makeReservation(2, 1);
        controller.removeReservation(2, 1);
        int y = controller.service.getAllFlights().get(0).getFreeSpaces();
        assertEquals(y, 107);
    }
}