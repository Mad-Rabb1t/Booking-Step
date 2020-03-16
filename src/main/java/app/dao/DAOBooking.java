package app.dao;


import app.entity.Booking;
import app.entity.Person;

import java.io.*;
import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBooking implements DAO<Booking> {

    List<Booking> bookings = new ArrayList<>();

    public DAOBooking() throws IOException {
        read();
    }

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

    private void read() throws IOException {
        File file = new File("bookings.txt");
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.trim().split("\\|");
            ArrayList<Person> people = new ArrayList<>();
            String[] passengers = info[2].split("~");
            for (String passenger : passengers) {
                String[] nameSurname = passenger.split(" ");
                people.add(new Person(nameSurname[0], nameSurname[1]));
            }
            create(new Booking(Integer.parseInt(info[0]), Integer.parseInt(info[1]), people));
        }
    }

    public void write() throws IOException {
        File file = new File("bookings.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String line;
        for (Booking b : bookings) {
            line = String.format("%d|%d|%s", b.getBookId(), b.getFlightId(), b.getPassengers());
            bw.write(line);
            bw.write("\n");
        }
        bw.close();

    }
}
