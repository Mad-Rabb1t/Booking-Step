package app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.Date;
import java.util.function.Predicate;

public class Predicates {
    public static Predicate<Booking> bookingsByPass(String name, String surname) {
        return booking -> booking.people.contains(new Person(name, surname));
    }

    public static Predicate<Booking> bookingById(int id){
        return booking -> booking.book_id == id;
    }

    public static Predicate<Flight> flightsById(int id) {
        return flight -> flight.fId == id;
    }

    public static Predicate<Flight> flightByInfo(String dest, LocalDate d, int seats) {
        return flight -> flight.date.getMonth().equals(d.getMonth()) && flight.date.getDayOfMonth() == d.getDayOfMonth()
                && flight.destination.equals(dest) && flight.freeSpaces >= seats;
    }

    public static Predicate<Flight> flightIn24H() {
        return flight -> flight.date.isBefore(LocalDateTime.now().plusHours(24)) && flight.date.isAfter((LocalDateTime.now()));
    }
}
