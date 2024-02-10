import java.time.LocalDate;
import java.util.*;

public class OnlineShoppingSystem {

    Scanner obj = new Scanner(System.in);
    //class of primitive type int to check datatype of a variable
    Class forIntegers = int.class;

    Map<Integer, Product> productsInventory = new HashMap<>();
    Map<Long, RegisteredUser> usersList = new HashMap<>();
    Map<Long, Orders> allOrders = new HashMap<>();
    //Base class for all the types of product
    abstract class Product{
        private int productId; //variable for product id
        private String productName; //variable for product name
        private double productPrice; //variable for product price
        private int Qty; //variable for quantity
        private String productType;

        //constructor
        Product(int id, String name, double price, int qty, String type){
            this.productId = id;
            this.productName = name;
            this.productPrice = price;
            this.Qty = qty;
            this.productType = type;
        }

        public int getProductId(){
            return productId;
        }
        public String getProductName(){
            return productName;
        }
        public double getProductPrice(){
            return productPrice;
        }
        public int getQty(){
            return Qty;
        }
        public String getProductType(){
            return productType;
        }
        public void setProductId(int id){
            this.productId = id;
        }
        public void setProductName(String name){
            this.productName = name;
        }
        public void setProductPrice(double price){
            this.productPrice = price;
        }
        public void setQty(int qty){
            this.Qty = qty;
        }
        public void setProductType(String type){
            this.productType = type;
        }
        //Method to display product details
        public void displayProductDetails(){
            System.out.println("Product Id : " + productId);
            System.out.println("Product Name : " + productName);
            System.out.println("Product Price : " + productPrice);
            System.out.println("Quantities Available :" + Qty);
            System.out.println("Product Type : " + productType);
        }
        //abstract method to display additional details for particular details
        abstract void displayAdditionalDetails();
    }
    //class for electronics types of products that inherits Product class
    class Electronics extends Product{
        int warrantyPeriod;  //variable that stores warranty period of the electronic product
        //constructor
        Electronics(int id, String name, double price, int qty, int warrantyPeriod, String type){
            super(id, name, price, qty, type);
            this.warrantyPeriod = warrantyPeriod;
        }

        public int getWarrantyPeriod(){
            return warrantyPeriod;
        }
        public void setWarrantyPeriod(int period){
            this.warrantyPeriod = period;
        }

        //method to display additional details of the product
        void displayAdditionalDetails(){
            System.out.println("Warranty Period : " + warrantyPeriod);
        }
    }
    //class for clothes types of products that inherits Product class
    class Clothing extends Product{
        String color; //variable to store color of the cloth
        String fabric; //variable to store fabric type of the cloth

        //constructor
        Clothing(int id, String name, double price, int qty, String color, String fabric, String type){
            super(id, name, price, qty, type);
            this.color = color;
            this.fabric = fabric;
        }

        public String getColor(){
            return color;
        }
        public String getFabric(){
            return fabric;
        }
        public void setColor(String color){
            this.color = color;
        }
        public void setFabric(String fabric){
            this.fabric = fabric;
        }
        //method to display additional details of the product
        void displayAdditionalDetails(){
            System.out.println("Cloth color : " + color);
            System.out.println("Fabric Type : " + fabric);
        }
    }

    //interface for necessary user actions
    interface UserActions{
        void browsingProducts();
        void addToTheCart();
        void placeOrder();
    }

    //class for registered user
    class RegisteredUser{
        String userName; //variable to store user's name
        String userEmail; //variable to store user's email
        long userMob; //variable to store user's mobile number
        ArrayList<Integer> Cart; //list to store products in a user's cart
        Map<Double, ArrayList<Integer>> orderHistory; //list to store order history of a user

        //constructor
        RegisteredUser(String name, String email, long mob){
            this.userName = name;
            this.userEmail = email;
            this.userMob = mob;
            this.Cart = new ArrayList<>();
            this.orderHistory = new HashMap<>();
        }

        void displayDetails(){
            System.out.println("User Mob : " + userMob);
            System.out.println("User Name : " + userName);
            System.out.println("User Email : " + userEmail);
        }
    }

    //class to store an order detail in the system
    class Orders{
        int orderId;
        long userMob;
        LocalDate orderDate;
        double orderAmount;
        ArrayList<Integer> productList;

        Orders(int oId, long mob, LocalDate date, double amt){
            this.orderId = oId;
            this.userMob = mob;
            this.orderDate = date;
            this.orderAmount = amt;
            this.productList = new ArrayList<>();
        }

        public void displayAllOrders(){
            System.out.println("Order Id : " + orderId);
            System.out.println("User Id : " + userMob);
            System.out.println("Order Date : " + orderDate);
            System.out.println("Products Bought are : ");
            for (Integer integer : productList) {
                System.out.println("Product Id : " + integer);
            }
            System.out.println("Total Amount : " + orderAmount);
        }
    }

    //class that contains all the implemented functions of online store
    class ShoppingOperations implements UserActions{
        //function to input id of a product
        public int inputId(){
            System.out.print("Enter Product Id (Integers Only) : ");
            int id = obj.nextInt();
//            if(!forIntegers.isInstance(id)){
//                System.out.println("Invalid Input, Try again..!!");
//                return inputId();
//            }
            return id;
        }
        //function to input product's name
        public String inputProName(){
            System.out.print("Enter the Product Name (Only alphabets) : ");
            String name = obj.next();
            boolean flag = false;
            for(int i = 0; i < name.length(); i++){
                if(name.charAt(i) != ' ' && !Character.isAlphabetic(name.charAt(i))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("Invalid format of the Product name, Try again...!!");
                return inputProName();
            }
            return name;
        }

        //function to add a new product
        public void addProduct(){
            int id = inputId();
            if(productsInventory.containsKey(id)){
                System.out.println("Product with same id already exist, try with a different product id...!!");
                addProduct();
            }
            String name = inputProName();
            System.out.print("Enter the price of the product : ");
            double price = obj.nextDouble();
            System.out.print("Enter the Quantity of the product : ");
            int qty = obj.nextInt();
            displayProductTypes();
            int typeChoice = obj.nextInt();
            String productType;
            switch(typeChoice){
                case 1:
                    productType = "Electronics";
                    System.out.print("Enter Warranty Period of the product : ");
                    int warranty = obj.nextInt();
                    Electronics e = new Electronics(id, name, price, qty, warranty, productType);
                    productsInventory.put(id, e);
                    break;
                case 2:
                    productType = "Clothes";
                    System.out.print("Enter color of the cloth : ");
                    String color = obj.next();
                    System.out.print("Enter the fabric of the cloth : ");
                    String fabric = obj.next();
                    Clothing c = new Clothing(id, name, price, qty, color, fabric, productType);
                    productsInventory.put(id, c);
                    break;
            }
            System.out.println("Product Added Successfully...!!");
            mainMenu();
        }

        //function to update details of a product
        public void updateProduct(){
            int id = inputId();
            if(!productsInventory.containsKey(id)){
                System.out.println("No product with this id found, try with another product id or add a new product..!!");
                System.out.println("Enter your Choice : ");
                System.out.println("1. Try Again...!!");
                System.out.println("2. Add a Product...!!");
                System.out.println("3. Main Menu");
                int choice = obj.nextInt();
                switch(choice){
                    case 1:
                        updateProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Invalid Input...!!");
                        break;
                }
            }
            else{
                Product p = productsInventory.get(id);
                productsInventory.remove(id);
                System.out.println("What you want to update...? ");
                System.out.println("1. Product's Id");
                System.out.println("2. Product's Name");
                System.out.println("3. Product's Price");
                System.out.println("4. Product's Quantity");
                String pType = p.getProductType();
                updateAccType(pType);
                int choice = obj.nextInt();
                switch (choice){
                    case 1:
                        int pId = inputId();
                        if(productsInventory.containsKey(pId)){
                            System.out.println("Product with this id already exist, try again with a different product id..!!");
                            pId = inputId();
                        }
                        p.setProductId(pId);
                        productsInventory.put(pId, p);
                        break;
                    case 2:
                        String pName = inputProName();
                        p.setProductName(pName);
                        break;
                    case 3:
                        System.out.print("Enter new price :");
                        double price = obj.nextDouble();
                        p.setProductPrice(price);
                        break;
                    case 4:
                        System.out.print("Enter the quantity : ");
                        int qty = obj.nextInt();
                        p.setQty(qty);
                        break;
                    case 5:
                        if(pType.equals("Electronics")){
                            System.out.print("Enter new warranty period : ");
                            int warran = obj.nextInt();
                            ((Electronics) p).setWarrantyPeriod(warran);
                        }
                        else if(pType.equals("Clothes")){
                            System.out.print("Enter new color : ");
                            String color = obj.next();
                            ((Clothing) p).setColor(color);
                        }
                        break;
                    case 6:
                        System.out.println("Enter the fabric of the cloth : ");
                        String fabric = obj.next();
                        ((Clothing) p).setFabric(fabric);
                        break;
                    default:
                        System.out.println("Invalid Choice...!!");
                        updateProduct();
                }
                if(choice != 1){
                    productsInventory.put(id, p);
                }
                System.out.println("Product Updated Successfully..!!!");
            }
            mainMenu();
        }

        //function to input mobile no.
        public long inputUserMobile(){
            System.out.print("Enter Mobile No. : ");
            long mob = obj.nextLong();
            return mob;
        }
        //function to input user's name and to check it's format
        public String inputUserName(){
            System.out.print("Enter the User's Name (Only alphabets) : ");
            String name = obj.next();
            boolean flag = false;
            for(int i = 0; i < name.length(); i++){
                if(name.charAt(i) != ' ' && !Character.isAlphabetic(name.charAt(i))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("Invalid format of the User name, Try again...!!");
                return inputUserName();
            }
            return name;
        }
        //function to register a new user
        public void registerUser(){
            long mob = inputUserMobile();
            if(usersList.containsKey(mob)){
                System.out.println("User with same Mobile no. already exist, try again with another mobile or continue to shopping..!!");
                System.out.println("Enter you choice : ");
                System.out.println("1. Try Again..!!");
                System.out.println("2. Browse Products");
                System.out.println("3. View Cart");
                System.out.println("4. Place Order");
                System.out.println("5. Main Menu");
                int choice = obj.nextInt();
                switch(choice){
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        browsingProducts();
                        break;
                    case 3:
                        userCart();
                        break;
                    case 4:
                        placeOrder();
                        break;
                    case 5:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Invalid Choice..!!");
                        break;
                }
            }
            String name = inputUserName();
            System.out.print("Enter user's email : ");
            String email = obj.next();
            RegisteredUser r = new RegisteredUser(name, email, mob);
            usersList.put(mob, r);
            System.out.println("User Registered Successfully...!!");
            mainMenu();
        }

        //function to update details of a user
        public void updateUser(){
            System.out.println("Enter User's mobile no. whose profile you want to update....!!!");
            long mob = inputUserMobile();
            if(!usersList.containsKey(mob)){
                System.out.print("User doesn't exist..!!");
                mainMenu();
                return;
            }
            RegisteredUser r = usersList.get(mob);
            usersList.remove(mob);
            System.out.println("What you want to update...??");
            System.out.println("1. Mobile No. ");
            System.out.println("2. Name ");
            System.out.println("3. Email ");
            int choice = obj.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter new Mobile No. : ");
                    long num = obj.nextLong();
                    r.userMob = num;
                    usersList.put(num, r);
                    break;
                case 2:
                    System.out.print("Enter new Name : ");
                    String name = obj.next();
                    r.userName = name;
                    usersList.put(mob, r);
                    break;
                case 3:
                    System.out.print("Enter new email : ");
                    String email = obj.next();
                    r.userEmail = email;
                    usersList.put(mob, r);
                default:
                    System.out.println("Invalid input...!!");
                    updateUser();
            }
            System.out.println("User's profile updated successfully...!!!");
            mainMenu();
        }

        //helper function to update product details according to their type
        public void updateAccType(String type){
            switch (type){
                case "Electronics":
                    System.out.println("5. Product's Warranty");
                    break;
                case "Clothes":
                    System.out.println("5. Product's color");
                    System.out.println("6. Product's fabric");
                    break;
                default:
                    System.out.println("Invalid Input...!!");
                    updateAccType(type);
                    break;
            }
        }

        //function to choose product type
        public void displayProductTypes(){
            System.out.println("Choose the type of the product : ");
            System.out.println("1. Electronics");
            System.out.println("2. Clothes");
        }

        //function to browse products
        @Override
        public void browsingProducts() {
            System.out.println("Products Available are : ");
            for(Map.Entry<Integer, Product> e : productsInventory.entrySet()){
                Product p = e.getValue();
                p.displayProductDetails();
                p.displayAdditionalDetails();
                System.out.println("---------------------------");
            }
            mainMenu();
        }

        //function to add a product to the cart
        @Override
        public void addToTheCart() {
            System.out.println("Add products to your cart...!!");
            long mob = inputUserMobile();
            if(!usersList.containsKey(mob)){
                System.out.println("You are not registered, register yourself first..!!");
                registerUser();
                addToTheCart();
            }
            RegisteredUser r = usersList.get(mob);
            int pId = inputId();
            if(!productsInventory.containsKey(pId)){
                System.out.println("Product Not found...!!");
                pId = inputId();
            }
            r.Cart.add(pId);
            System.out.println("Product added successfully to your cart...!!");
            System.out.println("Do you want to place order...?");
            System.out.println("1. Main Menu");
            System.out.println("2. Place Order");
            System.out.println("3. My Cart");
            int choice = obj.nextInt();
            switch (choice){
                case 1:
                    mainMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    userCart();
                    break;
                default:
                    System.out.println("Invalid choice....!!");
                    break;
            }
            mainMenu();
        }

        //function to place an order
        @Override
        public void placeOrder() {
            System.out.println("Place Order Now...!!");
            long mob = inputUserMobile();
            if(!usersList.containsKey(mob)){
                System.out.println("You are not registered, register yourself first..!!");
                registerUser();
                addProduct();
            }

            RegisteredUser r = usersList.get(mob);
            if(r.Cart.isEmpty()){
                addProduct();
            }
            double sum = 0.0;
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < r.Cart.size(); i++){
                Product p = productsInventory.get(r.Cart.get(i));
                sum += p.productPrice;
                a.add(r.Cart.get(i));
            }
            r.orderHistory.put(sum , a);
            Random rand = new Random();
            // Generate random integers in range 0 to 999
            int orderId = rand.nextInt(1000) + 1;
            Orders order = new Orders(orderId, mob, java.time.LocalDate.now(), sum);
            order.productList = new ArrayList<>(r.Cart);
            r.Cart.clear();
            allOrders.put(mob, order);
            System.out.println("Order Placed Successfully...!!");
            mainMenu();
        }

        //function to display all orders placed till now
        void displayAllOrdersTillDate(){
            System.out.println("All Orders till date  : ");
            for(Map.Entry<Long, Orders> e  : allOrders.entrySet()){
                Orders o = e.getValue();
                o.displayAllOrders();
            }
            mainMenu();
        }

        //function to display to cart of an user
        void userCart(){
            long mob = inputUserMobile();
            if(!usersList.containsKey(mob)){
                System.out.println("No user found");
                userCart();
            }
            RegisteredUser r = usersList.get(mob);
            if(r.Cart.isEmpty()){
                System.out.println("User's cart is empty..!!!");
                System.out.println("Add some products first..!!");
                browsingProducts();
                addToTheCart();
            }
            System.out.println("Your cart has following products : ");
            for(int i = 0; i < r.Cart.size(); i++){
                int pId = r.Cart.get(i);
                Product p = productsInventory.get(pId);
                p.displayProductDetails();
                p.displayAdditionalDetails();
                System.out.println("------------------------------------");
            }
            System.out.println("Do you want to place order...?");
            System.out.println("1. Main Menu");
            System.out.println("2. Place Order");
            int choice = obj.nextInt();
            switch (choice){
                case 1:
                    mainMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                default:
                    System.out.println("Invalid choice....!!");
                    break;
            }
            mainMenu();
        }

        //function to display order history of a particular user
        void userOrderHistory(){
            long mob = inputUserMobile();
            if(!usersList.containsKey(mob)){
                System.out.println("No user found");
                userCart();
            }
            RegisteredUser r = usersList.get(mob);
            if(r.orderHistory.isEmpty()){
                System.out.println("No order history found...!!");
            }
            System.out.println("Order history of the user with Mobile no. : " + mob);
            for(Map.Entry<Double, ArrayList<Integer>> e : r.orderHistory.entrySet()){
                double sum = e.getKey();
                ArrayList<Integer> list = e.getValue();
                for (int i = 0; i < list.size(); i++){
                    System.out.println("Product Id : " + list.get(i));
                }
                System.out.println("Total Bill : " + sum);
                System.out.println("------------------------------------");
            }
            mainMenu();
        }

        //function to display all registered user's details
        void displayAllUsers(){
            System.out.println("Registered Users are...!!!");
            for(Map.Entry<Long, RegisteredUser> e : usersList.entrySet()){
                RegisteredUser r = e.getValue();
                r.displayDetails();
                System.out.println("------------------------------");
            }
            mainMenu();
        }
    }

    //main menu function of online shopping class
    public void mainMenu(){
        ShoppingOperations s = new ShoppingOperations();
        System.out.println("Welcome to the Online Store...!!!");
        System.out.println("1. Add a Product to the product List");
        System.out.println("2. Update an existing product");
        System.out.println("3. Register User");
        System.out.println("4. Update User Details");
        System.out.println("5. Browse Products");
        System.out.println("6. Add a product to the cart");
        System.out.println("7. View User's Cart");
        System.out.println("8. Place Order");
        System.out.println("9. Display Order History of an user");
        System.out.println("10. Display all orders till date");
        System.out.println("11. Display all registered Users");
        int choice = obj.nextInt();
        switch (choice){
            case 1:
                s.addProduct();
                break;
            case 2:
                s.updateProduct();
                break;
            case 3:
                s.registerUser();
                break;
            case 4:
                s.updateUser();
                break;
            case 5:
                s.browsingProducts();
                break;
            case 6:
                s.addToTheCart();
                break;
            case 7:
                s.userCart();
                break;
            case 8:
                s.placeOrder();
                break;
            case 9:
                s.userOrderHistory();
                break;
            case 10:
                s.displayAllOrdersTillDate();
                break;
            case 11:
                s.displayAllUsers();
                break;
            default:
                System.out.println("Invalid Input....!!");
                break;
        }
        mainMenu();
    }

    public static void main(String[] args){
        OnlineShoppingSystem o = new OnlineShoppingSystem();
        o.obj.useDelimiter("\\n");
        o.mainMenu();
    }
}
