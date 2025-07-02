public class RoomServiceImpl<T extends Room> implements RoomService<T> {

    @Override
    public void clean(T room) {
        System.out.println("Комната " + room.getNumber() + " была почищена.");
    }

    @Override
    public void reserve(T room) {
        if (room.isBooked()) {
            throw new RoomAlreadyReservedException("Комната уже забронирована!");
        }
        room.setBooked(true);
        System.out.println("Комната " + room.getNumber() + " успешно забронирована.");
    }

    @Override
    public void free(T room) {
        if (!room.isBooked()) {
            throw new RoomNotReservedException("Комната уже свободна!");
        }
        room.setBooked(false);
        System.out.println("Комната " + room.getNumber() + " теперь свободна.");
    }

    public static class RoomAlreadyReservedException extends RuntimeException {
        public RoomAlreadyReservedException(String message) {
            super(message);
        }
    }
    public static class RoomNotReservedException extends RuntimeException {
        public RoomNotReservedException(String message) {
            super(message);
        }
    }

}
