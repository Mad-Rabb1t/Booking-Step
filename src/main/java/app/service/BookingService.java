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

    public void createBooking(int f_id, List<Person> passengers) {
        daoBooking.create(new Booking(getAllBookings().get(getAllBookings().size() - 1).getBook_id() + 1, f_id, passengers));
    }

    public void deleteBooking(int id) {
        for (Booking booking : getAllBookings()) {
            if (booking.getBook_id() == id) {
                getAllBookings().remove(booking);
                break;
            }
        }
    }

    public Collection<Booking> getBookingsByPassenger(String name, String surname) {
        return daoBooking.getAllBy(Predicates.bookingsByPass(name, surname));
    }


}
