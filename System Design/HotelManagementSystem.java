/*
https://www.youtube.com/watch?v=5VWycK8KmW0&list=PL12BCqE-Lp650Cg6FZW7SoZwN8Rw1WJI7&index=1

Requirements:
For a single hotel

- User/System can book a room by providing dates
- User/System can checkin and checkout
- User/System can search for an empty room
- A room has various types: Economy, Deluxe, Suite
- User/System can make payment based on the room type
- Admin can add/remove a room
- User can avail room services like ordering food, which would be charged extra
- The system should allow the users to cancel the booking
- System should be able to send notification to users when checkin/checkout
  dates are near
- System should maintain a housekeeping log to track of all housekeeping tasks
- The user can pay throught credit card, check or cash

Actors:
1. Guest 
2. Receptionist
3. Server/System
4. Admin
5. Housekeeper

Use cases:
1. Add/remove/edit room
2. Check-in
3. Check-out
4. Book
5. Cancel
6. Add room charge
7. Update houskeeping log
8. Search room
*/

class Hotel {
    Integer hotelId;
    String name;
    Location hotelLocation;
    List<Room> rooms;
}

class Location {
    String street;
    String area;
    String city;
    String state;
    int pin;
    String country;
}

class Room {
    Integer roomId;
    String roomName;
    RoomType roomType;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs;
}

abstract class RoomType {
    public abstract Double getCost();
    public abstract String getDesc();
}

class StandardRoom extends RoomType {
    Double getCost();
    String getDesc();
}

class DeluxeRoom extends RoomType {
    Double getCost();
    String getDesc();
}

class SuiteRoom extends RoomType {
    Double getCost();
    String getDesc();
}

enum RoomStatus {
    AVAILABLE, RESERVED, NOT_AVAILABLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

class RoomKey {
    Integer keyId;
    String barCode;
    Room assignedRoom;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room) {
        this.assignedRoom = room;
    }
}

class HouseKeepingLog {
    String description;
    Room room;
    Date startDate;
    Integer duration;
    HouseKeeper houseKeeper;

    public void addRoom(Room room);
}

class Person {
    String name;
    Acount accountDetail;
    String phone;
}

class Account {
    String username;
    String password;
    AccountStatus accountStatus;

    public boolean resetPassword();
}

enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {
    public List<Room> getRoomsServiced(Date date);
}

class Guest extends Person {
    SearchService searchService;
    BookService bookingService;

    public List<RoomBooking> getAllRoomBookings();
}

class Receptionist extends Person {
    SearchService searchService;
    BookingService bookingService;

    public void checkInGuest(Guest guest, RoomBooking bookingInfo);
    public void checkOutGuest(Guest guest, RoomBooking bookingInfo);
}

class Admin extends Person {
    public boolean addRoom(Room room);
    public Room deleteRoom(Integer roomId);
    public boolean editRoom(Room room);
}

interface SearchService {
    public List<Room> searchRoom(RoomType roomType, Date startDate, int duration);
}

abstract class Service {
    public String getDesc();
    public Double getCost();
}

class RoomService extends Service () {
    public String getDesc();
    public Double getCost();
}

class HouseKeepingService extends Service () {
    public String getDesc();
    public Double getCost();
}

class LaundryService extends Service () {
    public String getDesc();
    public Double getCost();
}

class RoomBooking {
    Integer bookingId;
    Date startDate;
    Integer durationInDays;
    Account account; //the person who actually booked    
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomList;

    public getTotalCost(List<Service> services, RoomType roomType) {
        int totalCost = 0;
        for(Service service: services) {
            totalCost += service.getCost();
        }
        totalCost += roomType.getCost();
    }
    return totalCost;
}

interface BookingService {
    public RoomBooking createBooking(RoomBooking bookingInfo);
    public RoomBooking cancelBooking(Integer bookingId);
}

