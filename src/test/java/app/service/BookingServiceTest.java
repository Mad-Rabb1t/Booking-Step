package app.service;

import app.dao.DAOBooking;
import app.entity.Booking;
import app.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    BookingService bookingService;

    @BeforeEach
    public void initialize() throws IOException {
        this.bookingService = new BookingService();
    }

    @Test
    void getAllBookings() {
        Booking booking = new Booking(1, 1, null);
        bookingService.daoBooking.create(booking);
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        bookingService.getAllBookings();
        assertEquals(bookingService.getAllBookings(), bookings);
    }

    @Test
    void getMyBookings() {

    }

    @Test
    void createBooking() {
        Booking booking = (new Booking(1, 3, null));
        List<Booking> book = new ArrayList<>();
        book.add(booking);
        bookingService.createBooking(3, null);
        List<Booking> bookings = (List<Booking>) bookingService.daoBooking.getAll();
        assertEquals(book, bookings);//It does not work
    }

    @Test
    void deleteBooking() {
        Booking booking = new Booking(1, 1, null);
        bookingService.daoBooking.create(booking);
        bookingService.deleteBooking(0);
        String expected = "Booking deleted";
        assertEquals(bookingService.deleteBooking(1), "Booking deleted");
    }

    @Test
    void getBookingById() {

    }

    @Test
    void getNumOfSeats() {
        Person mary = new Person("Mary", "Black");
        Person michael = new Person("Michael", "Black");
        Booking booking = new Booking(1, 1, new ArrayList<Person>(Arrays.asList(mary, michael)));
        bookingService.daoBooking.create(booking);
        int x = bookingService.getNumOfSeats(1);
        assertEquals(x, 2);
    }
}