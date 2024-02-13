package Feb12_CarRental;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
// Car rental system class
public class carRentalSystem {

    Scanner sc = new Scanner(System.in);
    // List to store all the vehicles
    Map<String, Vehicle> carList = new HashMap<>();
    // List to store all the customers
    Map<Integer, Customer> custList = new HashMap<>();

    // Abstract class representing a vehicle
    abstract class Vehicle{
        private String Num;
        private String Make;
        private String Model;
        private int year;
        private double rentalPrice;

        // Constructor for Vehicle class
        Vehicle(String number, String make, String model, int year, double rent){
            this.Num = number;
            this.Make = make;
            this.Model = model;
            this.year = year;
            this.rentalPrice = rent;
        }

        // Getter methods
        public String getNum(){
            return Num;
        }
        public String getMake(){
            return Make;
        }
        public String getModel(){
            return Model;
        }
        public int getYear(){
            return year;
        }
        public double getRentalPrice(){
            return rentalPrice;
        }

        // Setter method for rental price
        public void setRentalPrice(double price){
            this.rentalPrice = price;
        }

        // Method to display vehicle details
        public void displayDetails(){
            System.out.println("Vehicle Number : " + Num);
            System.out.println("Make of Vehicle : " + Make);
            System.out.println("Model : " + Model);
            System.out.println("Year of Manufacturing : " + year);
            System.out.println("Rental Price per day : " + rentalPrice);
        }

        // Abstract methods
        abstract void displayAdditionalDetails();
        abstract double calculateRentalCost();
    }

    // Class representing a Car which extends Vehicle
    class Car extends Vehicle{
        int numSeats;
        String fuelType;

        // Constructor for Car class
        Car(String num, String make, String model, int year, double price, int seats,String fuel){
            super(num, make, model, year, price);
            this.numSeats = seats;
            this.fuelType = fuel;
        }

        // Getter methods
        public int getNumSeats(){
            return numSeats;
        }
        public String getFuelType(){
            return fuelType;
        }
        // Setter methods
        public void setNumSeats(int seats){
            this.numSeats = seats;
        }
        public void setFuelType(String fuel){
            this.fuelType = fuel;
        }

        // Method to calculate rental cost of a car
        public double calculateRentalCost(){
            System.out.print("Enter no. of days, the Car is being rented for: ");
            int no_days = sc.nextInt();
            double price_per_day = getRentalPrice();
            return no_days * price_per_day;
        }

        // Method to display additional details of a car
        public void displayAdditionalDetails(){
            System.out.println("No. of seats : " + numSeats);
            System.out.println("Fuel Type : " + fuelType);
        }
    }

    // Class representing a Customer
    class Customer{
        private int custNum;
        private String cusName;
        private String cusEmail;
        private long cusPhn;
        Map<String, Vehicle> rentedVehicles;

        // Constructor for Customer class
        Customer(int num, String name, String email, long phn){
            this.custNum = num;
            this.cusName = name;
            this.cusEmail = email;
            this.cusPhn = phn;
            rentedVehicles = new HashMap<>();
        }

        // Getter methods
        public int getCustNum(){
            return custNum;
        }
        public String getCusName(){
            return cusName;
        }
        public String getCusEmail(){
            return cusEmail;
        }
        public long getCusPhn(){
            return cusPhn;
        }

        // Setter methods
        public void setCustNum(int num){
            this.custNum = num;
        }
        public void setCusName(String name){
            this.cusName = name;
        }
        public void setCusEmail(String Email){
            this.cusEmail = Email;
        }
        public void setCusPhn(long phn){
            this.cusPhn = phn;
        }

        // Method to display customer details
        public void displayCustDetails(){
            System.out.println("Customer Number : " + custNum);
            System.out.println("Customer Name : " + cusName);
            System.out.println("Customer's Email : " + cusEmail);
            System.out.println("Customer's Phone no. : " + cusPhn);
            System.out.println("Vehicle numbers of the vehicle's Rented by the customer are : ");
            for(Map.Entry<String, Vehicle> e : rentedVehicles.entrySet()){
                System.out.println("Vehicle Number : " + e.getKey());
            }
            System.out.println("----------------------------------------------");
        }
    }

    // Interface representing Payment functionality
    interface Payment{
        int makePayment();
    }

    // Class representing the rental agency
    class rentalAgency implements Payment{

        // Method to input car number
        public String inputCarNum(){
            System.out.print("Enter the vehicle No. : ");
            String num = sc.next();
            if(carList.containsKey(num)){
                System.out.println("Car with the same car number already exist..!!, Try again..!!");
                return inputCarNum();
            }
            return num;
        }

        // Method to choose fuel type
        public String chooseFuel(){
            System.out.println("Choose the fuel Type : ");
            System.out.println("1.Petrol");
            System.out.println("2.Diesel");
            System.out.println("3.CNG");
            int c = sc.nextInt();
            String fuel = "";
            switch (c){
                case 1:
                    fuel = "Petrol";
                    break;
                case 2:
                    fuel = "Diesel";
                    break;
                case 3:
                    fuel = "CNG";
                    break;
                default:
                    System.out.println("Invalid Input..!!");
                    return chooseFuel();
            }
            return fuel;
        }
        public void addVehicle(){
            String num = inputCarNum();
            System.out.print("Enter Make of the vehicle : ");
            String make = sc.next();
            System.out.print("Enter the model of the vehicle : ");
            String model = sc.next();
            System.out.print("Enter the year of manufacturing : ");
            int year = sc.nextInt();
            System.out.print("Enter per day rent of the vehicle : ");
            double price = sc.nextDouble();
            System.out.println("Choose the type of vehicles : ");
            System.out.println("1.Car");
            System.out.println("2.Others");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter No. of seats : ");
                    int seats = sc.nextInt();
                    String fuel = chooseFuel();
                    Vehicle v = new Car(num, make, model, year, price, seats, fuel);
                    carList.put(num, v);
                    mainMenu();
                    break;
                case 2:
                    System.out.println("Other vehicles Coming soon...!!!");
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid input...!!");
                    mainMenu();
                    break;
            }
        }

        // Method to search for a vehicle
        public void searchVehicle(){
            System.out.println("Find a Vehicle to rent..!!");
            System.out.print("Enter Vehicle Number : ");
            String num = sc.next();
            if(!carList.containsKey(num)){
                System.out.println("No vehicle with this vehicle no. exist in the inventory..!!");
                searchVehicle();
            }
            Vehicle foundVehicle = carList.get(num);
            foundVehicle.displayDetails();
            foundVehicle.displayAdditionalDetails();
            System.out.println("-----------------------------------");
            mainMenu();
        }

        // Method to display all vehicles available for rent
        public void displayAllVehicles(){
            System.out.println("Vehicles available for rent are...!!");
            for(Map.Entry<String, Vehicle> e : carList.entrySet()){
                Vehicle v = e.getValue();
                v.displayDetails();
                v.displayAdditionalDetails();
                System.out.println("-------------------------------");
            }
            mainMenu();
        }

        // Method to input customer number
        public int inputCustNum(){
            System.out.print("Enter Customer Number : ");
            int num = sc.nextInt();
            if(custList.containsKey(num)){
                System.out.println("Customer with the same number already exist..!! \n Try again...!!");
                return inputCustNum();
            }
            return num;
        }

        // Method to add a customer
        public void addCustomer(){
            System.out.println("Be a customer in are agency...!!!");
            int num = inputCustNum();
            System.out.print("Enter Customer's Name : ");
            String name = sc.next();
            System.out.print("Enter Customer's Email : ");
            String email = sc.next();
            System.out.print("Enter Customer's Phone no. : ");
            long phn = sc.nextLong();
            Customer cust = new Customer(num, name, email, phn);
            custList.put(num, cust);
            mainMenu();
        }

        // Method to initiate payment
        public int makePayment(){
            System.out.println("Proceed to payment ..?");
            System.out.println("1.Yes");
            System.out.println("2.Cancel");
            int choice = sc.nextInt();
            return choice;
        }

        // Method to rent a vehicle
        public void rentVehicle(){
            System.out.println("Rent a vehicle...!!");
            System.out.println("Enter the type of vehicle you want to rent : ");
            System.out.println("1.Car");
            System.out.println("2.Others");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Vehicle Number : ");
                    String num = sc.next();
                    if(!carList.containsKey(num)){
                        System.out.println("Vehicle Not available for rent..!! \n It is already rented to some customer...!!");
                        rentVehicle();
                    }
                    System.out.print("Enter Customer Number : ");
                    int custNum = sc.nextInt();
                    if(!custList.containsKey(custNum)){
                        System.out.println("Customer not registered..!! \n Register the customer first..!!");
                        addCustomer();
                    }
                    Vehicle v = carList.get(num);
                    double rental_price = v.calculateRentalCost();
                    System.out.println("Total Rental price : " + rental_price);
                    int ch = makePayment();
                    if(ch == 1){
                        Customer cust = custList.get(custNum);
                        cust.rentedVehicles.put(num, v);
                        carList.remove(num);
                        System.out.println("Payment Successful...!!");
                        System.out.println("Car rented Successfully...!!");
                        mainMenu();
                    }
                    else{
                        System.out.println("Payment Failed...!!!");
                        rentVehicle();
                    }
                    break;
                case 2:
                    System.out.println("Other Vehicles coming soon..!!");
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice..!!");
                    rentVehicle();
            }
        }

        // Method to return a vehicle
        public void returnVehicle(){
            System.out.println("Return a vehicle...!!");
            System.out.println("Enter the type of vehicle you want to return : ");
            System.out.println("1.Car");
            System.out.println("2.Others");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Number : ");
                    String num = sc.next();
                    if (carList.containsKey(num)) {
                        System.out.println("Vehicle already available for rent..!! \n Can't Return..!!");
                        rentVehicle();
                    }
                    System.out.print("Enter Customer Number : ");
                    int custNum = sc.nextInt();
                    if (!custList.containsKey(custNum)) {
                        System.out.println("Customer not registered..!! \n Can't return as never rented a vehicle..!!");
//                        addCustomer();
                        mainMenu();
                    }
                    Customer cust = custList.get(custNum);
                    Vehicle v = cust.rentedVehicles.get(num);
                    carList.put(num, v);
                    cust.rentedVehicles.remove(num);
                    System.out.println("Car returned successfully..!!");
                    mainMenu();
                    break;
                case 2:
                    System.out.println("Other vehicles coming soon...!!!");
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Choice...!!1");
                    rentVehicle();
            }
        }

        // Method to display all customers
        public void displayAllCustomers(){
            System.out.println("************************************");
            System.out.println("Existing Customers in the agency are...!!!");
            System.out.println("************************************");
            for(Map.Entry<Integer, Customer> e : custList.entrySet()){
                Customer c = e.getValue();
                c.displayCustDetails();
            }
            mainMenu();
        }

        // Method to search for a customer
        public void searchCustomer(){
            System.out.println("Enter Customer Number : ");
            int custNum = sc.nextInt();
            if(!custList.containsKey(custNum)){
                System.out.println("No Customer with the entered customer number found..!!");
                searchCustomer();
            }
            Customer c = custList.get(custNum);
            c.displayCustDetails();
            mainMenu();
        }

        // Method to update rental price of a vehicle
        public void updateRentalPrice(){
            System.out.println("Enter vehicle Number : ");
            String vNum = sc.next();
            if(!carList.containsKey(vNum)){
                System.out.println("No vehicle found..!!");
                updateRentalPrice();
            }
            Vehicle v = carList.get(vNum);
            System.out.println("Enter new rental price for the vehicle :");
            double price = sc.nextDouble();
            v.setRentalPrice(price);
            System.out.println("Price Updated Successfully...!!!");
            mainMenu();
        }
    }

    public void mainMenu(){
        System.out.println("*****************************************");
        System.out.println("Welcome to Vehicle rental agency....!!!");
        System.out.println("*****************************************");
        System.out.println("1.Add a vehicle");
        System.out.println("2.Search a vehicle");
        System.out.println("3.Display all vehicles available for rent");
        System.out.println("4.Add a new Customer");
        System.out.println("5.Rent a vehicle");
        System.out.println("6.Return a vehicle");
        System.out.println("7.Display all customers");
        System.out.println("8.Search for a customer");
        System.out.println("9.Update rental price of a vehicle");
        // Prompt the user for input
        int choice = sc.nextInt();

        // Create an instance of the rentalAgency class
        rentalAgency obj = new rentalAgency();

        // Switch statement to handle user choice
        switch (choice){
            case 1:
                // Add a vehicle
                obj.addVehicle();
                break;
            case 2:
                // Search for a vehicle
                obj.searchVehicle();
                break;
            case 3:
                // Display all vehicles available for rent
                obj.displayAllVehicles();
                break;
            case 4:
                // Add a new customer
                obj.addCustomer();
                break;
            case 5:
                // Rent a vehicle
                obj.rentVehicle();
                break;
            case 6:
                // Return a vehicle
                obj.returnVehicle();
                break;
            case 7:
                // Display all customers
                obj.displayAllCustomers();
                break;
            case 8:
                // Search for a customer
                obj.searchCustomer();
                break;
            case 9:
                // Update rental price of a vehicle
                obj.updateRentalPrice();
                break;
            default:
                // Handle invalid input
                System.out.println("Invalid input...!!!");
                // Display the main menu again
                mainMenu();
                break;
        }
    }

    // Main method to start the program
    public static void main(String[] args){
        // Create an instance of the carRentalSystem class
        carRentalSystem obj = new carRentalSystem();
        // Set the delimiter for scanner to handle multiline input
        obj.sc.useDelimiter("\\n");
        // Display the main menu to start the program
        obj.mainMenu();
    }
}

