package app.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight {
  int fId;
  String destination;
  LocalDateTime date;
  int freeSpaces;

  public Flight(int f_id, String destination, LocalDateTime date, int freeSpaces) {
    this.fId = f_id;
    this.destination = destination;
     this.date = date;
    this.freeSpaces = freeSpaces;
  }

  public Flight(int fId){
    this.fId = fId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return fId == flight.fId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fId);
  }
}
