package app.io;

import app.controller.BookingController;
import app.controller.FlightController;

import java.util.Scanner;

public class ConsoleMain implements Console {

  private Scanner sc = new Scanner(System.in);
  FlightController flight;
  BookingController booking;

  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }

  public void displayMainMenu(){
    print("================================================================\n");
    print("                         Main menu                              \n");
    print("================================================================\n");
    print("1. Online-board                             4.Cancel the booking\n");
    print("2.Show the flight info                      5.My flights\n");
    print("3.Search and booking a flight               6.Exit\n\n");
  }
}
