package app.service;


import app.dao.DAOFlights;
import app.entity.Flight;
import app.entity.Predicates;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class FlightService {

  DAOFlights flight = new DAOFlights();

  public ArrayList<Flight> getAllFlights() {
    return (ArrayList<Flight>) flight.getAll();
  }


  public ArrayList<Flight> getFlights24H() {
    return (ArrayList<Flight>) flight.getAllBy(Predicates.flightIn24H());
  }


  public Flight getFlightBy(Predicate<Flight> p) {
    return getAllFlights().stream().filter(p).findFirst()
            .orElseThrow(()-> new IllegalArgumentException("Flights with such parameters are not found"));
  }

  public Collection<Flight> getFlightsBy(String dest, String date, int seats) {
    return flight.getAllBy(Predicates.flightByInfo(dest,
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            seats));
  }

  public void occupySeats(int seats, int id){
    getFlightBy(Predicates.flightsById(id)).occupySeats(seats);
  }


}
