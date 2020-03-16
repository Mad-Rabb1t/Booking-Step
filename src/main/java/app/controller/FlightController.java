package app.controller;


import app.entity.Flight;
import app.io.ConsoleMain;
import app.service.FlightService;
import app.entity.Predicates;

import java.time.LocalDate;
import java.util.Collection;

public class FlightController {
    FlightService service = new FlightService();
    ConsoleMain console = new ConsoleMain();

    public void show24H() {
        if(service.getFlights24H().size() == 0){
            console.printLn("No flights available for the next 24 hours!");
        } else {
            console.printLn("Flights in the next 24 hours: ");
            service.getFlights24H().forEach(s -> console.printLn(s.toString()));
        }
    }

    public void showInfo() {
        console.print("Enter flight id: ");
        try {
            console.printLn(service.getFlightBy(Predicates.flightsById(Integer.parseInt(console.readLn()))).toString());
        } catch (Exception ex) {
            console.printLn(ex.getMessage());
        }
    }

    public Collection<Flight> showFlightsByInfo(String dest, LocalDate date, int seats) {
        return service.getFlightsBy(dest, date, seats);
    }

    public void makeReservation(int seats, int id) {
        service.occupySeats(seats, id);
    }

    public void removeReservation(int seats, int id) {
        service.occupySeats(seats * (-1), id);
    }

}
