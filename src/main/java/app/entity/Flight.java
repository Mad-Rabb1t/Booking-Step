package app.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
  int fId;
  String destination;
  LocalDateTime date;
  int freeSpaces;

  public Flight(int f_id, String destination, LocalDateTime date, int free_spaces) {
    this.fId = f_id;
    this.destination = destination;
     this.date = date;
    this.freeSpaces = free_spaces;
  }

  public int getfId() {
    return fId;
  }

  public String getDestination() {
    return destination;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public int getFreeSpaces() {
    return freeSpaces;
  }

  public void occupySeats(int seats) {
    freeSpaces -= seats;
  }

  @Override
  public String toString() {
    return String.format("Flight number %d from Kiev to %s on %s. Spaces available: %d", fId, destination,
            date.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm")), freeSpaces);
  }
}
