package app.io;

import app.entity.Airport;
import app.entity.Flight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Generator {

    public void generator(){
        List<Flight> fly = new ArrayList<>();
        List<Airport> cities = Arrays.asList(Airport.values());
        Random random = new Random();


        for (int i = 1; i <11 ; i++) {
            int randomSeats = random.nextInt(100)+50;
            int h = random.nextInt(24);
            int d = random.nextInt(30);
            int m = random.nextInt(60);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String flightsDate = LocalDateTime.now().plusHours(h).plusDays(d).plusMinutes(m).format(formatter);
            LocalDateTime ldt = LocalDateTime.parse(flightsDate);
            fly.add(new Flight(i, String.valueOf(cities.get(random.nextInt(cities.size()))), ldt, randomSeats));
        }
        try {
            File file = new File("flights.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Flight fl : fly){
                DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String line = String.format("%d|%s|%s|%d", fl.getfId(), fl.getDestination(), fl.getDate().format(form), fl.getFreeSpaces());
                bw.write(line);
                bw.write("\n");
            }
            bw.close();
        }catch (IOException ex){
            System.out.println("Can not find a file");
        }



    }



}
