package app.entity;

import java.util.List;

public class Booking {
  List<Person> people;
//  int user_id;
  int flight_id;
  int book_id;

  public Booking(int book_id, int flight_id, List<Person> people){
    this.book_id = book_id;
    this.flight_id = flight_id;
    this.people = people;
  }

  public int getBook_id() {
    return book_id;
  }
}
