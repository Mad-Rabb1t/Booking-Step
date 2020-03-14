package app.dao;

import app.entity.Flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlights implements DAO<Flight> {
    List<Flight> flights = new ArrayList<>();


    @Override
    public Optional<Flight> get(int id) {
        return flights.stream()
                .filter(flight -> flight.getfId() == id)
                .findFirst();
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
        flights.remove(flights.iterator().next().getfId());
    }

    public void read() {
        try {
            DAO<Flight> flight = new DAOFlights();
            File file = new File("C:\\Users\\iturk\\Desktop\\IBA\\Booking-Step\\flights.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] inf = line.trim().split("\\|");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime ldt = LocalDateTime.parse(inf[2], formatter);
                flight.create(new Flight(Integer.parseInt(inf[0]), inf[1], ldt, Integer.parseInt(inf[3])));
            }
        } catch (Exception ex) {
            System.out.println("File not found");
        }

    }
}

