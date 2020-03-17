package app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}