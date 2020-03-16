package app.controller;


import app.entity.Booking;
import app.entity.Person;
import app.io.ConsoleMain;
import app.service.BookingService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookingController {
    ConsoleMain console = new ConsoleMain();
    BookingService service;

    {
        try {
            service = new BookingService();
        } catch (IOException e) {
            console.printLn("JVM is playing tricks on you!");
        }
    }

    public void show() {
        console.print("Enter name: ");
        String name = console.readLn();
        console.print("Enter surname: ");
        String surname = console.readLn();
        Collection<Booking> bookings = service.getMyBookings(name, surname);
        if (bookings.size() == 0) {
            console.printLn("Bookings for specified person haven't been found!");
        } else {
            bookings.forEach(booking -> console.printLn(booking.toString()));
        }
    }

    public void book(int id, int numOfPass) {
        List<Person> passengers = new ArrayList<>();
        for (int i = 0; i < numOfPass; i++) {
            console.print("Enter passenger's name: ");
            String name = console.readLn();
            console.print("Enter passenger's surname: ");
            String surname = console.readLn();
            passengers.add(new Person(name, surname));
        }
        service.createBooking(id, passengers);
    }

    public void cancel(int id) {
        console.printLn(service.deleteBooking(id));
    }

    public int getFlightIdInBooking(int bookId) {
        try {
            return service.getBookingById(bookId).getFlightId();
        } catch (Exception ex) {
            console.printLn(ex.getMessage());
        }
        return -1;
    }

    public int getNumOfSeats(int bookId) {
        return service.getNumOfSeats(bookId);
    }

    public void close() {
      try {
        service.save();
      } catch (IOException e) {
        console.printLn("Aliens broke your JVM");
      }
    }
}
