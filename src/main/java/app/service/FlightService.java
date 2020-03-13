package app.service;


import app.dao.DAO;
import app.dao.DAOBooking;
import app.dao.DAOFlights;
import app.entity.Airport;
import app.entity.Flight;
import app.entity.Predicates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightService {

  DAOFlights flight;

  public ArrayList<Flight> getAllFlights() {
    return (ArrayList<Flight>) flight.getAll();
  }


  public ArrayList<Flight> getFlights24H() {
    return (ArrayList<Flight>) flight.getAllBy(Predicates.flightIn24H());
  }

//  public Flight getFlightBy(int id){
//    return flight.get(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
//}
  public Flight getFlightBy(Predicate<Flight> p) {
    return getAllFlights().stream().filter(p).findFirst()
            .orElseThrow(()-> new IllegalArgumentException("Flights with such parameters are not found"));
  }
}
