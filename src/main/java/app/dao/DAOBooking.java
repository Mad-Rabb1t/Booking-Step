package app.dao;

import lesson15.app.entity.Booking;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class DAOBooking implements DAO<Booking> {
  @Override
  public Optional<Booking> get(int id) {
    return Optional.empty();
  }

  @Override
  public Collection<Booking> getAll() {
    return null;
  }

  @Override
  public Collection<Booking> getAllBy(Predicate<Booking> p) {
    return null;
  }

  @Override
  public void create(Booking data) {

  }

  @Override
  public void delete(int id) {

  }
}
