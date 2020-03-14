package app.controller;


import app.io.ConsoleMain;
import app.service.FlightService;
import app.entity.Predicates;

import java.time.LocalDate;

public class FlightController {
    FlightService service;
    ConsoleMain console;

    public void show24H() {
        console.printLn(service.getFlights24H().stream().toString());
    }

    public void showInfo(int flyId) {
        console.print("Enter flight id: ");
        console.printLn(service.getFlightBy(Predicates.flightsById(Integer.parseInt(console.readLn()))).toString());
    }

    public void showFlightsByInfo(String dest, String date, int seats) {
        console.printLn(service.getFlightsBy(dest,date,seats).stream().toString());
    }

    public void makeReservation(int seats, int id) {
        service.occupySeats(seats, id);
    }

    public void removeReservation(int seats, int id) {
        service.occupySeats(seats * (-1), id);
    }

}
