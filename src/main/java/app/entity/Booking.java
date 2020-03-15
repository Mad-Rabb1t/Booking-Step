package app.entity;

import java.util.List;

public class Booking {
  List<Person> people;
//  int user_id;
  int flightId;
  int bookId;

  public Booking(int bookId, int flightId, List<Person> people){
    this.bookId = bookId;
    this.flightId = flightId;
    this.people = people;
  }

  public int getBookId() {
    return bookId;
  }

  public int getFlightId() {
    return flightId;
  }

  public int getSeats(){
    return people.size();
  }

  @Override
  public String toString() {
    return String.format("Booking number %d reserved for flight number %d, amount of passengers: %d\n", bookId, flightId,
            people.size());
  }
}
