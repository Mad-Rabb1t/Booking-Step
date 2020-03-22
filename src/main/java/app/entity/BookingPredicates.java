package app.entity;

import java.util.function.Predicate;

public class BookingPredicates {
    public static Predicate<Booking> bookingsByPass(String name, String surname) {
        return booking -> booking.people.contains(new Person(name, surname));
    }

    public static Predicate<Booking> bookingById(int id){
        return booking -> booking.bookId == id;
    }
}
