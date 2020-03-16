package app.controller;

import app.entity.Booking;
import app.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {

    BookingController bookingController;

    @BeforeEach
    public void initialize() {
        this.bookingController = new BookingController();
    }

    @Test
    void getFlightIdInBooking() {
        bookingController.service.createBooking(2, null);
        int x = bookingController.getFlightIdInBooking(1);
        assertEquals(x, 2);
    }

    @Test
    void getNumOfSeats() {
        Person mary = new Person("Mary", "Black");
        Person michael = new Person("Michael", "Black");
        bookingController.service.createBooking(1,  new ArrayList<Person>(Arrays.asList(mary, michael)));
        int y = bookingController.getNumOfSeats(1);
        assertEquals(y, 2);
    }
}