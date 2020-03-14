package app.controller;


import app.entity.Person;
import app.io.Console;
import app.io.ConsoleMain;
import app.service.BookingService;

import java.util.ArrayList;
import java.util.List;

public class BookingController {
  BookingService service;
  Console console;

  public BookingController(ConsoleMain console, BookingService service) {
    this.service = service;
    this.console = console;
  }

  public void show() {
    console.print("Enter name: ");
    String name = console.readLn();
    console.print("Enter surname: ");
    String surname = console.readLn();
    console.printLn(service.getMyBookings(name,surname).iterator().next().toString());
  }

  public void book(int id, int numOfPass) {
    List<Person> passengers = new ArrayList<>();
    for(int i=0; i < numOfPass; i++){
      console.print("Enter passenger's name: ");
      String name = console.readLn();
      console.print("Enter passenger's surname: ");
      String surname = console.readLn();
      passengers.add(new Person(name,surname));
    }
    service.createBooking(id,passengers);
  }

  public void cancel(int id){
    console.printLn(service.deleteBooking(id));
  }

  public int getFlightIdInBooking(int bookId){
    try {
     return service.getBookingById(bookId).getFlight_id();
    } catch (Exception ex) {
      console.printLn(ex.getMessage());
    }
    return -1;
  }

  public int getNumOfSeats(int bookId){
    return service.getNumOfSeats(bookId);
  }
}
