package app.controller;


import app.io.Console;
import app.io.ConsoleMain;
import app.service.BookingService;

public class Controller {
  BookingService service;
  Console console;

  public Controller(ConsoleMain console, BookingService service) {
    this.service = service;
    this.console = console;
  }

  public void show() {
    service.getAllBookings();
  }

  public void search() {
    console.readLn();
  }

  public void book() {
    console.printLn("");
  }
}
