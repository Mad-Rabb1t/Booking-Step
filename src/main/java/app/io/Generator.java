package app.io;

import app.entity.Airport;
import app.entity.Flight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Generator {

    public void generator(){
        List<Flight> fly = new ArrayList<Flight>();
        List<Airport> cities = Arrays.asList(Airport.values());
//        List<String> cities = new ArrayList<String>(Arrays.asList("Baku", "London", "Milan", "Moscow", "Berlin", "Paris"));
        Random random = new Random();



        for (int i = 1; i <11 ; i++) {
            int randomSeats = random.nextInt(100)+50;
            int h = random.nextInt(24);
            int d = random.nextInt(30);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String flightsDate = LocalDateTime.now().plusHours(h).plusDays(d).format(formatter);
            fly.add(new Flight(i, cities.get(random.nextInt(cities.size())), flightsDate, randomSeats));
        }
        try {
            File file = new File("flights.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Flight fl : fly){
//                String line = String.valueOf(fl);
                String line = String.format("%d|%s|%s|%d", fl.getF_id(), fl.getDestination(), fl.getDate(), fl.getFree_spaces());
                bw.write(line);
                bw.write("\n");


            }
            bw.close();
        }catch (IOException ex){
            System.out.println("Can not find a file");
        }



    }



}
