package app.controller;


import app.io.Console;
import app.io.ConsoleMain;
import app.service.Service;

public class Controller {
  Service service;
  Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

  public void show() {
    service.getallFlights();
  }

  public void search() {
    console.readLn();
  }

  public void book() {
    console.printLn("");
  }
}
