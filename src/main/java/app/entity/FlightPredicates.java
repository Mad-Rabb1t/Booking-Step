package app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

public class FlightPredicates {

    public static Predicate<Flight> flightsById(int id) {
        return flight -> flight.fId == id;
    }

    public static Predicate<Flight> flightByInfo(String dest, LocalDate d, int seats) {
        return flight -> flight.date.getMonth().equals(d.getMonth()) && flight.date.getDayOfMonth() == d.getDayOfMonth()
                && flight.destination.toLowerCase().equals(dest.toLowerCase().trim()) && flight.freeSpaces >= seats;
    }

    public static Predicate<Flight> flightIn24H() {
        return flight -> flight.date.isBefore(LocalDateTime.now().plusHours(24)) && flight.date.isAfter((LocalDateTime.now()));
    }
}
