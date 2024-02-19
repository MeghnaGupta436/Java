package Feb16;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
class Account{
    private final BigInteger cardNumber;
    int pinNumber;
    double balance;

    Account(BigInteger num, int pin){
        this.cardNumber = num;
        this.pinNumber = pin;
        this.balance = 0.0;
    }
    BigInteger getCardNumber(){
        return cardNumber;
    }
    int getPinNumber(){
        return pinNumber;
    }
    double getBalance(){
        return balance;
    }

    void setPinNumber(int pin){
        this.pinNumber = pin;
    }
    void setBalance(double bal){
        this.balance = bal;
    }
}

class adminActions{
    Scanner sc = new Scanner(System.in);
    public BigInteger inputAccNumber(){
        System.out.println("Enter Card Number : ");
        BigInteger cardNumber = sc.nextBigInteger();
        try {
            if(ATMsimulation.accounts.containsKey(cardNumber)){
                throw new Exception("Account with the card number : " + cardNumber + " already exists...!!");
            }
            return cardNumber;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return inputAccNumber();
        }
    }
    public void addAccount(){
        BigInteger cardNumber = inputAccNumber();
        System.out.println("Enter a default pin for the account holder : ");
        int defaultPIN = sc.nextInt();
        Account newAccount = new Account(cardNumber, defaultPIN);
        ATMsimulation.accounts.put(cardNumber, newAccount);
        System.out.println("Account added successfully...!!!");
        System.out.println("--------------------------------------");
    }

    public void deleteAccount(){
        System.out.println("Enter Card Number : ");
        BigInteger cardNumber = sc.nextBigInteger();
        try{
            if(!ATMsimulation.accounts.containsKey(cardNumber)){
                throw new Exception("No account found with the card number : " + cardNumber);
            }
            ATMsimulation.accounts.remove(cardNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Account deleted successfully...!!!");
        System.out.println("--------------------------------------");
    }
}
class userActions{
    Scanner sc = new Scanner(System.in);
    public void checkBalance(BigInteger cardNum){
        System.out.println("Balance : " + ATMsimulation.accounts.get(cardNum).getBalance());
        System.out.println("Thank you for choosing SBI ATM...!!!");
        System.out.println("---------------------------------------");
    }

    public void cashWithdrawal(BigInteger cardNum){
        System.out.println("Enter the amount : ");
        double amount = sc.nextDouble();
        try{
            if(ATMsimulation.accounts.get(cardNum).getBalance() < amount){
                throw new Exception("Insufficient Balance...!!!");
            }
            Account acc = ATMsimulation.accounts.get(cardNum);
            acc.setBalance(acc.getBalance() - amount);
            System.out.println("Your Withdrawal is Successfully done...!!");
            System.out.println("Slip is printing..!!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Remove your card..!!");
        System.out.println("---------------------------------------");
    }
    public void cashDeposit(BigInteger cardNum){
        System.out.println("Enter the amount : ");
        double amount = sc.nextDouble();
        Account acc = ATMsimulation.accounts.get(cardNum);
        acc.setBalance(acc.getBalance() + amount);
        System.out.println("Your cash deposited Successfully...!!");
        System.out.println("Slip is printing..!!");
        System.out.println("Remove your card..!!");
        System.out.println("---------------------------------------");
    }
    public void transfer(BigInteger cardNum){
        System.out.println("Enter receiver's card number : ");
        BigInteger recCardNum = sc.nextBigInteger();
        try {
            if(!ATMsimulation.accounts.containsKey(recCardNum)){
                throw new Exception("No account found with the card number : " + recCardNum);
            }
            System.out.println("Enter the amount : ");
            double amount = sc.nextDouble();
            Account acc = ATMsimulation.accounts.get(cardNum);
            if(acc.getBalance() < amount){
                throw new Exception("Insufficient balance..!!!");
            }
            acc.setBalance(acc.getBalance() - amount);
            Account recAcc = ATMsimulation.accounts.get(recCardNum);
            recAcc.setBalance(recAcc.getBalance() + amount);
            System.out.println("Funds Transferred Successfully...!!!");
            System.out.println("---------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changePIN(BigInteger cardNum){
        System.out.println("Enter new pin : ");
        int newPin = sc.nextInt();
        System.out.println("Re-Enter new pin : ");
        int reNewPin = sc.nextInt();
        try{
            Account acc = ATMsimulation.accounts.get(cardNum);
            if(newPin == acc.getPinNumber()){
                throw new Exception("New pin can't be same as old one...!!");
            } else if (newPin != reNewPin) {
                throw new Exception("Pin doesn't match...!!");
            }
            acc.setPinNumber(newPin);
            System.out.println("Pin Changed Successfully..!!");
            System.out.println("---------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


public class ATMsimulation {

    Scanner sc = new Scanner(System.in);
    static Map<BigInteger,Account> accounts = new HashMap<>();

    adminActions admin = new adminActions();
    userActions user = new userActions();

    public BigInteger userAuthentication(){
        System.out.println("Enter your card Number : ");
        BigInteger cardNum = sc.nextBigInteger();
        System.out.println("Enter your PIN : ");
        int pin = sc.nextInt();
        try {
            if(!accounts.containsKey(cardNum)){
                throw new Exception("No account exist with the card Number : " + cardNum);
            } else if (pin != accounts.get(cardNum).getPinNumber()) {
                throw new Exception("Invalid Pin, Authentication failed...!!");
            }
            return cardNum;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return BigInteger.valueOf(-1);
        }
    }
    public void mainMenu(){
        System.out.println("Who are you...??");
        System.out.println("1.User");
        System.out.println("2.Admin");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                BigInteger authentication = userAuthentication();
                if(Objects.equals(authentication, BigInteger.valueOf(-1))){
                    mainMenu();
                }else{
                    userMainMenu(authentication);
                }
                break;
            case 2:
                System.out.println("Enter admin Id : ");
                int id = sc.nextInt();
                System.out.println("Enter password : ");
                String pass = sc.next();
                try {
                    if(id != 12345 || !Objects.equals(pass, "deep")){
                        throw new Exception("Invalid credentials...!!");
                    }
                    adminMainMenu();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    mainMenu();
                }
                break;
            case 3:
                System.out.println("Invalid Input..!!");
                break;

        }
    }

    public void adminMainMenu(){
        System.out.println("Welcome to admin Panel..!!");
        System.out.println("1.Add an account");
        System.out.println("2.Delete an account");
        System.out.println("3.Logout");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                admin.addAccount();
                break;
            case 2:
                admin.deleteAccount();
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Input...!!");
                break;
        }
        adminMainMenu();
    }

    public void userMainMenu(BigInteger cardNumber){
        System.out.println("Welcome to State Bank of India ATM..!!!");
        System.out.println("1.Balance Inquiry");
        System.out.println("2.Cash Withdrawal");
        System.out.println("3.Cash Deposit");
        System.out.println("4.Transfer");
        System.out.println("5.Change PIN");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                user.checkBalance(cardNumber);
                break;
            case 2:
                user.cashWithdrawal(cardNumber);
                break;
            case 3:
                user.cashDeposit(cardNumber);
                break;
            case 4:
                user.transfer(cardNumber);
                break;
            case 5:
                user.changePIN(cardNumber);
                break;
            default:
                System.out.println("Invalid Input...!!");
                break;
        }
        mainMenu();
    }
    public static void main(String[] args) {
        ATMsimulation ATM = new ATMsimulation();
        ATM.mainMenu();
    }
}
