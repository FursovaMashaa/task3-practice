import java.util.Random;

public abstract class Room {
    private int number;
    private int maxGuests;
    private int pricePerNight;
    private boolean isBooked;

    public Room(int number, int maxGuests, int pricePerNight) {
        this.number = number;
        this.maxGuests = maxGuests;
        this.pricePerNight  = pricePerNight;
        this.isBooked = false;
    }
    public Room(int number, int pricePerNight) {
        this(number, new Random().nextInt(4) + 1, pricePerNight); // maxGuests от 1 до 4
    }

    public int getNumber() {
        return number;
    }
    public int getMaxGuests() {
        return maxGuests;
    }
    public int getPricePerNight() {
        return pricePerNight;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
    @Override
    public String toString() {
        return String.format("Номер %d | Гостей: %d | Цена: %d р. | %s",
                number, maxGuests, pricePerNight,
                isBooked ? "Забронирован" : "Свободен");
    }

}

