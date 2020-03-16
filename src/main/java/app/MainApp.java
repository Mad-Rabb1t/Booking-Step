package app;


import app.controller.BookingController;
import app.controller.FlightController;
import app.dao.DAOBooking;
import app.entity.Flight;
import app.io.ConsoleMain;
import app.io.Generator;
import app.service.BookingService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;

public class MainApp {
  public static void main(String[] args) {


    ConsoleMain console = new ConsoleMain();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();

//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
    BookingController bookingController = new BookingController();
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
    FlightController flightController = new FlightController();

    try {
      Generator g = new Generator();
      g.generator();
    } catch (IOException ex){
      console.printLn("Couldn't find the database file. Creating a new one...");
    }

    boolean exit = false;

    while (!exit) {
      console.displayMainMenu();
      String input = console.readLn();
      switch (input) {
        case "1": flightController.show24H(); break;
        case "2": flightController.showInfo(); break;
        case "3": {
          console.print("Enter destination: ");
          String dest = console.readLn();
          console.print("Enter desired date(in the following format: 'DD/MM/YYYY'): ");
          LocalDate date ;
          while(true) {
            try {
              date = LocalDate.parse(console.readLn(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
              break;
            } catch(DateTimeParseException ex){
              console.print("Invalid date format. Please enter in the appropriate format:");
            }
          }
          console.print("Enter number of seats you wish to book:");
          int seats = Integer.parseInt(console.readLn());
          Collection<Flight> foundFlights = flightController.showFlightsByInfo(dest, date, seats);
          if(foundFlights.size() == 0){
            console.printLn("Flights with specified parameters haven't been found");
          } else {
            console.printLn("Available flights: ");
            foundFlights.forEach(flight -> console.printLn(flight.toString()));
            console.print("Enter id of flight to book or '0' to return to main menu: ");
            while (true) {
              int id = Integer.parseInt(console.readLn());
              if (id == 0) break;
              if (foundFlights.contains(new Flight(id))) {
                  bookingController.book(id, seats);
                  flightController.makeReservation(seats, id);
                  console.printLn("Booking has been created!");
                  break;
              } else {
                console.print("Enter id of one of the flights above or '0' to return to main menu: ");
              }
            }
          }
          break;
        }

        case "4": {
          console.print("Enter the id of booking to be cancelled: ");
          int id = Integer.parseInt(console.readLn());
          try {
            flightController.removeReservation(bookingController.getNumOfSeats(id),
                    bookingController.getFlightIdInBooking(id));
            bookingController.cancel(id);
          } catch (Exception ex){
            console.printLn(ex.getMessage());
          }
          break;
        }

        case "5": bookingController.show(); break;
        case "6":{
//          ...
          exit = true;
          break;
        }
        default: console.printLn("Select item from 1 to 6\n"); break;
      }
    }
  }
}
