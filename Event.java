package ticketMaster;

class Event {
    private String name;
    private int availableSeats;

    public Event(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
    }

    public String getName() {
        return name;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        availableSeats -= numSeats;
    }

    public void cancelSeats(int numSeats) {
        availableSeats += numSeats;
    }
}