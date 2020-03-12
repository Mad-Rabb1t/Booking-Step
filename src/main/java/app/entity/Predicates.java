package app.entity;

import java.util.function.Predicate;

public class Predicates {
    public Predicate<Booking> bookingsById(int id){
        return bookings -> bookings.flight_id == id;
    }

    public Predicate<Flight> flightsById(int id){
        return bookings -> bookings.f_id == id;
    }
}
