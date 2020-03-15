package app.io;

import app.entity.Airport;
import app.entity.Flight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Generator {

    public void generator() throws IOException {
        List<Airport> cities = Arrays.asList(Airport.values());
        Random random = new Random();

        File file = new File("flights.txt");
        if (!file.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 10; i++) {
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
    }


}
