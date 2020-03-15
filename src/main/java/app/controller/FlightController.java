package app.controller;


import app.io.ConsoleMain;
import app.service.FlightService;
import app.entity.Predicates;

import java.time.LocalDate;

public class FlightController {
    FlightService service = new FlightService();
    ConsoleMain console = new ConsoleMain();

    public void show24H() {
        service.getFlights24H().forEach(s -> console.printLn(s.toString()));
    }

    public void showInfo() {
        console.print("Enter flight id: ");
        try {
            console.printLn(service.getFlightBy(Predicates.flightsById(Integer.parseInt(console.readLn()))).toString());
        } catch (Exception ex){
            console.printLn(ex.getMessage());
        }
    }

    public void showFlightsByInfo(String dest, String date, int seats) {
        service.getFlightsBy(dest,date,seats).forEach(flight -> console.printLn(flight.toString()));
    }

    public void makeReservation(int seats, int id) {
        service.occupySeats(seats, id);
    }

    public void removeReservation(int seats, int id) {
        service.occupySeats(seats * (-1), id);
    }

}
