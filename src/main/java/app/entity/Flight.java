package app.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Flight {
  int f_id;
  Airport destination;
  String date;
  int free_spaces;

  public Flight(int f_id, Airport destination, String date, int free_spaces) {
    this.f_id = f_id;
    this.destination = destination;
//    LocalDateTime date =

     this.date = date;
    this.free_spaces = free_spaces;
  }

  public int getF_id() {
    return f_id;
  }

  public Airport getDestination() {
    return destination;
  }

  public String getDate() {
    return date;
  }

  public int getFree_spaces() {
    return free_spaces;
  }
}
