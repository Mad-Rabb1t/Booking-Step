package app.service;


import app.dao.DAOBooking;
import app.entity.Booking;
import app.entity.Person;
import app.entity.Predicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookingService {
    DAOBooking daoBooking;

    public BookingService(DAOBooking daoBooking) {
        this.daoBooking = daoBooking;
    }

    public ArrayList<Booking> getAllBookings() {
        return (ArrayList<Booking>) daoBooking.getAll();
    }

    public Collection<Booking> getMyBookings(String name, String surname) {
        return daoBooking.getAllBy(Predicates.bookingsByPass(name, surname));
    }

    public void createBooking(int fId, List<Person> passengers) {
        int bId;
        if (getAllBookings().size() == 0) {
            bId = 1;
        } else {
            bId = getAllBookings().get(getAllBookings().size() - 1).getBookId() + 1;
        }
        daoBooking.create(new Booking(bId, fId, passengers));
    }

    public String deleteBooking(int id) {
        for (Booking booking : getAllBookings()) {
            if (booking.getBookId() == id) {
                getAllBookings().remove(booking);
                return "Booking deleted";
            }
        }
        return "Booking with such id was not found";
    }

    public Collection<Booking> getBookingsByPassenger(String name, String surname) {
        return daoBooking.getAllBy(Predicates.bookingsByPass(name, surname));
    }

    public Booking getBookingById(int id) {
        return daoBooking.getAll().stream().filter(Predicates.bookingById(id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Booking was not found"));
    }

    public int getNumOfSeats(int id) {
        return getBookingById(id).getSeats();
    }


}
