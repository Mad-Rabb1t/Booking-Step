package app.entity;

import java.util.function.Predicate;

public class Predicates {
    public static Predicate<Booking> bookingsByPass(String name, String surname){
        return booking -> booking.people.contains(new Person(name, surname));
    }

    public static Predicate<Flight> flightsById(int id){
        return flight -> flight.f_id == id;
    }
}
