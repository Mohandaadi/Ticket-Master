package ticketMaster;

class BookingRequest {
    private String eventName;
    private int numSeats;

    public BookingRequest(String eventName, int numSeats) {
        this.eventName = eventName;
        this.numSeats = numSeats;
    }

    public String getEventName() {
        return eventName;
    }

    public int getNumSeats() {
        return numSeats;
    }
}
