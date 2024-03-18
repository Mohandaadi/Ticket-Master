package ticketMaster;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketBookingSyatem bookingSystem = new TicketBookingSyatem();

        // Adding events
        bookingSystem.addEvent("Concert", 99);
        bookingSystem.addEvent("Movie", 49);

        // Booking tickets
        bookingSystem.bookTickets("Concert", 3);
        bookingSystem.bookTickets("Movie", 2);

        // Attempting to book more tickets than available
        bookingSystem.bookTickets("Concert", 150);
        bookingSystem.bookTickets("Movie", 150);

        // Canceling tickets
        bookingSystem.cancelTickets("Concert", 2);

        // Processing booking queue
        bookingSystem.processBookingQueue();
        bookingSystem.bookTickets("Concert", 1);

        // Displaying available events
        bookingSystem.displayEvents();
	}

}
