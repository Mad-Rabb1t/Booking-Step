package projectTests;

import app.entity.Flight;
import app.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightServiceTest {

  private FlightService service;

  @BeforeEach
  public void initialize() {
    this.service = new FlightService();
  }

  @Test
  public void getFlights24HTest() {
    ArrayList<Flight> expected = new ArrayList<>();
    ArrayList<Flight> actual = service.getFlights24H();
    assertEquals(expected, actual);
  }

  @Test
  public void getFlightsByTest() {
    String dest = "";
    LocalDate date = null;
    int seats = 0;
    Collection<Flight> expected = null;
    Collection<Flight> actual = service.getFlightsBy(dest, date, seats);
    assertEquals(expected, actual);
  }
}
