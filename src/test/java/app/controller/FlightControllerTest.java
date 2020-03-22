package app.controller;

import app.entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        assertEquals(60, x);
    }

    @Test
    void removeReservation() {
        controller.makeReservation(2, 2);
        controller.removeReservation(2, 2);
        int y = controller.service.getAllFlights().get(1).getFreeSpaces();
        assertEquals(98, y);
    }

    @Test
    void showFlightsByInfo(){
        Flight fl = new Flight(2020, "LA", LocalDateTime.now().plusHours(6), 100);
        controller.service.getAllFlights().add(fl);
        controller.showFlightsByInfo("LA", LocalDate.now(), 2);
        assertTrue(controller.showFlightsByInfo("LA", LocalDate.now(), 2).contains(fl));
    }

    @Test
    void show24H(){
        Flight fl = new Flight(2020, "LA", LocalDateTime.now().plusHours(6), 100);
        controller.service.getAllFlights().add(fl);
        assertTrue(controller.service.getFlights24H().contains(fl));
        controller.service.getAllFlights().remove(fl);
    }
}