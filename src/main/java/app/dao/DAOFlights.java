package app.dao;

import app.entity.Flight;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlights implements DAO<Flight> {
    List<Flight> flights = new ArrayList<>();

    @Override
    public Optional<Flight> get(int id) {

        return Optional.of(flights.get(id));
    }

    @Override
    public Collection<Flight> getAll() {
        return flights;
    }

    @Override
    public Collection<Flight> getAllBy(Predicate<Flight> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Flight data) {
        flights.add(data);
    }

    @Override
    public void delete(int id) {
        flights.remove(id);
    }
}

