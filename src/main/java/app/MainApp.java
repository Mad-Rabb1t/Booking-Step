package app;


import app.controller.BookingController;
import app.dao.DAOBooking;
import app.io.ConsoleMain;
import app.io.Generator;
import app.service.BookingService;

public class MainApp {
  public static void main(String[] args) {

    Generator g = new Generator();
    g.generator();

    ConsoleMain console = new ConsoleMain();
    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
    BookingService service = new BookingService(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
    BookingController controller = new BookingController(console, service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);

    while (true) {
      String input = console.readLn();
      switch (input) {
        case "1": controller.show(); break;
        case "2": controller.search(); break;
        case "3": controller.book(); break;
        case "4": ; break;
        case "5": ; break;
        default:  break;
      }
    }
  }
}
