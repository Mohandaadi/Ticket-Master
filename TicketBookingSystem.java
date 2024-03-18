package ticketMaster;
import java.util.*;

class TicketBookingSyatem {
    private Map<String, Event> eventMap;
    private Queue<BookingRequest> bookingQueue;

    public TicketBookingSyatem() {
        eventMap = new HashMap<>();
        bookingQueue = new LinkedList<>();
    }

    public void addEvent(String eventName, int availableSeats) {
        eventMap.put(eventName, new Event(eventName, availableSeats));
    }

    public void bookTickets(String eventName, int numSeats) {
        if (!eventMap.containsKey(eventName)) {
            System.out.println("Event '" + eventName + "' does not exist.");
            return;
        }

        Event event = eventMap.get(eventName);
        if (event.getAvailableSeats() >= numSeats) {
            event.bookSeats(numSeats);
            System.out.println(numSeats + " tickets booked for event '" + eventName + "'.");
        } else {
            System.out.println("Insufficient seats available for event '" + eventName + "'.");
            bookingQueue.offer(new BookingRequest(eventName, numSeats));
        }
    }

    public void cancelTickets(String eventName, int numSeats) {
        if (!eventMap.containsKey(eventName)) {
            System.out.println("Event '" + eventName + "' does not exist.");
            return;
        }

        Event event = eventMap.get(eventName);
        event.cancelSeats(numSeats);
        System.out.println(numSeats + " tickets canceled for event '" + eventName + "'.");
    }

    public void processBookingQueue() {
        while (!bookingQueue.isEmpty()) {
            BookingRequest request = bookingQueue.poll();
            String eventName = request.getEventName();
            int numSeats = request.getNumSeats();

            if (eventMap.containsKey(eventName)) {
                Event event = eventMap.get(eventName);
                if (event.getAvailableSeats() >= numSeats) {
                    event.bookSeats(numSeats);
                    System.out.println(numSeats + " tickets booked for event '" + eventName + "' from the booking queue.");
                } else {
                    System.out.println("Insufficient seats available for event '" + eventName + "' from the booking queue.");
                }
            } else {
                System.out.println("Event '" + eventName + "' does not exist. Booking request from the queue discarded.");
            }
        }
    }



    public void displayEvents() {
        System.out.println("Available Events:");
        for (Event event : eventMap.values()) {
            System.out.println(event.getName() + ": " + event.getAvailableSeats() + " seats available.");
        }
    }
}
