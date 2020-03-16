package app.dao;

import app.entity.Airport;
import app.entity.Flight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlights implements DAO<Flight> {
    List<Flight> flights = new ArrayList<>();

    public DAOFlights() throws IOException {
        read();
    }

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
        flights.remove(id);
    }

    public void read() throws IOException {

        File file = new File("flights.txt");
        if (!file.exists()) {
            List<Airport> cities = Arrays.asList(Airport.values());
            Random random = new Random();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 1; i < 31; i++) {
                int randomSeats = random.nextInt(100) + 50;
                int h = random.nextInt(24);
                int d = random.nextInt(30);
                int m = random.nextInt(60);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String flightsDate = LocalDateTime.now().plusHours(h).plusDays(d).plusMinutes(m).format(formatter);
                String line = String.format("%d|%s|%s|%d", i, cities.get(random.nextInt(cities.size())),
                        flightsDate, randomSeats);
                bw.write(line);
                bw.write("\n");
            }
            bw.close();
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] inf = line.trim().split("\\|");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime ldt = LocalDateTime.parse(inf[2], formatter);
            create(new Flight(Integer.parseInt(inf[0]), inf[1], ldt, Integer.parseInt(inf[3])));
        }
        br.close();
    }

    public void write() throws IOException {
        File file = new File("flights.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String line;
        for (Flight f: flights) {
            line = String.format("%d|%s|%s|%d", f.getfId(), f.getDestination(), f.getDate().format(formatter),f.getFreeSpaces());
            bw.write(line);
            bw.write("\n");
        }
        bw.close();
    }


}

