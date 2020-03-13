package app.service;


import app.dao.DAO;
import app.dao.DAOBooking;
import app.dao.DAOFlights;
import app.entity.Flight;
import app.entity.Predicates;

import java.util.List;

public class FlightService {
  DAO<Flight> flight = new DAOFlights();

  public void showFlightById(int id){
//      flight.getAllBy(Predicates.flightsById(id));
  }
//  public List<Flight> getFlights24H(){
//    return flight.getAllBy()
//  }

}
