package Feb15;
import java.util.*;
//import javafx.util.Pair;
class Flight{ //Flight Class
    private int flightNumber;
    private String departureCity;
    private String destinationCity;
    private int availableSeats;

    Flight(int num, String depCity, String desCity, int seats){
        this.flightNumber = num;
        this.departureCity = depCity;
        this.destinationCity = desCity;
        this.availableSeats = seats;
    }

    int getFlightNumber(){
        return flightNumber;
    }
    String getDepartureCity(){
        return departureCity;
    }
    String getDestinationCity(){
        return destinationCity;
    }
    int getAvailableSeats(){
        return availableSeats;
    }
    void setDepartureCity(String city){
        this.departureCity = city;
    }

    void setDestinationCity(String city){
        this.destinationCity = city;
    }

    void setAvailableSeats(int num){
        this.availableSeats = num;
    }

    public void printFlightDetails(){
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Departure City : " + departureCity);
        System.out.println("Destination City : " + destinationCity);
        System.out.println("No. of seats available : " + availableSeats);
        System.out.println("********************************");
    }
}

class ReservationException extends Exception{
    public ReservationException(String message){
        super(message);
    }

}

//Class for reservations of flights
public class FlightReservationSystem {

    Scanner sc = new Scanner(System.in);
    private Map<Integer, Flight> flightList;
    private Map<String, Flight> reservations;

    public FlightReservationSystem() {
        this.reservations = new HashMap<>();
        this.flightList = new HashMap<>();
    }

    //adding a new flight
    public void addFlight(int flightNumber, String depCity, String desCity, int numSeats) {
        try {
            if (flightList.containsKey(flightNumber)){
                throw new ReservationException("Flight with light no. "  + flightNumber + " already exist...!!!");
            }
            Flight f = new Flight(flightNumber, depCity, desCity, numSeats);
            flightList.put(flightNumber, f);
        } catch(ReservationException e){
            System.out.println(e.getMessage());
        }
    }

    //booking a flight

    public void makeReservation(int flightNumber, String passengerName, int numSeats){
        try{
            if (!flightList.containsKey(flightNumber)) {
                throw new ReservationException("No Flight with " + flightNumber + " found...!!");
            } else {
                if (flightList.get(flightNumber).getAvailableSeats() <= 0) {
                    throw new ReservationException("No seats available in " + flightNumber + " flight");
                }
                else if(flightList.get(flightNumber).getAvailableSeats() < numSeats){
                    throw new ReservationException("Number of seats available are less than you are requesting...!!!");
                }
                else if(numSeats < 0){
                    throw new ReservationException("Negative number of seats not allowed..!!");
                }
            }
            Flight f = flightList.get(flightNumber);
            f.setAvailableSeats(f.getAvailableSeats() - numSeats);
            reservations.put(passengerName, f);
            System.out.println("Reservation for " + passengerName + " is successful.");
        }catch (ReservationException e){
            System.out.println(e.getMessage());
        }
    }

    //cancelling a booked flight
    public void cancelReservation(String passengerName) {
        try{
            if (!reservations.containsKey(passengerName)) {
                throw new ReservationException("No reservation found for " + passengerName + ".");
            }
            Flight f = reservations.get(passengerName);
            f.setAvailableSeats(f.getAvailableSeats() + 1);
            reservations.remove(passengerName);
            System.out.println("Reservation for " + passengerName + " at flight " + f.getFlightNumber() + " is cancelled.");
        }
        catch(ReservationException e){
            System.out.println(e.getMessage());
        }
    }

    public void displayAllFlights(){
        System.out.println("******************************");
        System.out.println("   !!!...Flights are...!!!");
        System.out.println("******************************");

        for(Map.Entry<Integer, Flight> e : flightList.entrySet()){
            Flight f = e.getValue();
            f.printFlightDetails();
        }
    }

    public void mainMenu(){
        System.out.println("Welcome to Flight Booking System...!!!");
        System.out.println("Choose From : ");
        System.out.println("1.Add a flight");
        System.out.println("2.Book a flight");
        System.out.println("3.Cancel a flight");
        System.out.println("4.Display all flights");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter Flight Number : ");
                int flightNum = sc.nextInt();
                System.out.println("Enter Departure City : ");
                String depCity = sc.next();
                System.out.println("Enter Destination City : ");
                String desCity = sc.next();
                System.out.println("Enter Number of Seats : ");
                int seats = sc.nextInt();
                addFlight(flightNum, depCity, desCity, seats);
                break;
            case 2:
                displayAllFlights();
                System.out.println("Enter Flight Number : ");
                int num = sc.nextInt();
                System.out.println("Enter your Name : ");
                String name = sc.next();
                System.out.println("No. of seats :  ");
                int nSeats = sc.nextInt();
                makeReservation(num, name, nSeats);
                break;
            case 3:
                System.out.println("Enter Your Name : ");
                String pName = sc.next();
                cancelReservation(pName);
                break;
            case 4:
                displayAllFlights();
                break;
            default:
                System.out.println("Invalid Input...!!");
                break;
        }
        mainMenu();
    }


    public static void main(String[] args) {
        FlightReservationSystem obj = new FlightReservationSystem();
        obj.addFlight(12345, "chd", "knp", 60);
        obj.addFlight(12346, "chd", "dli", 54);
        obj.mainMenu();
    }


}

