package app.service;


import app.dao.DAOBooking;

public class BookingService {
  DAOBooking daoBooking;
  public BookingService(DAOBooking daoBooking) {
    this.daoBooking = daoBooking;
  }

  public void getAllBookings() {

  }
}
