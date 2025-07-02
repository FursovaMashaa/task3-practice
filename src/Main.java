public class Main {
    public static void main(String[] args) {
        RoomService<Room> service = new RoomServiceImpl<>();

        Room room1 = new EconomyRoom(111, 2500);
        Room room2 = new UltraLuxRoom(222, 15000);
        Room room3 = new LuxRoom(333, 10000);

        service.clean(room1);
        service.reserve(room1);

        try {
            service.reserve(room1);
        } catch (RoomServiceImpl.RoomAlreadyReservedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        service.free(room1);

        try {
            service.free(room1);
        } catch (RoomServiceImpl.RoomNotReservedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        service.reserve(room2);
        service.reserve(room3);

        service.clean(room1);
        service.clean(room2);
        service.clean(room3);

        service.free(room2);
        service.free(room3);

        try {
            service.free(room2);
        } catch (RoomServiceImpl.RoomNotReservedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
