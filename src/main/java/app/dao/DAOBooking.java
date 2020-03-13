package app.dao;



import app.entity.Booking;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBooking implements DAO<Booking> {

  List<Booking> bookings = new ArrayList<>();

  @Override
  public Optional<Booking> get(int id) {
   return Optional.of(bookings.get(id));
  }

  @Override
  public Collection<Booking> getAll() {
    return bookings;
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public void create(Booking data) {
    bookings.add(data);
  }

  @Override
  public void delete(int id) {
    bookings.remove(id);
  }
}
