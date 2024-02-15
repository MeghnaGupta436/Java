package Feb14;
import java.util.*;

class BankAccount{                                                          //class BankAccount
    String bankAccount;
    double balance;

    public BankAccount(String bankAccount, double balance) {            //constructor to bank account
        this.bankAccount = bankAccount;
        this.balance = balance;
    }
    public BankAccount()                                         //used for initalize the object without any value(default values)
    {
    }
}
class Transaction{                                  //class Transaction
    double TransactionID;
    int TransactionType;
    double amount;

    public Transaction(double transactionID, int transactionType, double amount) {      //Transaction class constructor
        TransactionID = transactionID;
        TransactionType = transactionType;
        this.amount = amount;
    }
}
class BankingException extends Exception{
    double amount;
    public String error1(double amount,BankAccount account)              //exception for withdraw amount
    {
        if(amount>account.balance)
            return "You are not having sufficent amount  ";
        else if(amount<0)
            return "You can not withdrwa a negative ammount";
        else if (amount>100000)
            return "you can not withdrwa more than 1LAKH in one transaction";
        return null;

    }
    public String error2(double amount,BankAccount account)     //exception for deopsit amount
    {
        if(amount>50000)
            return "very large amount to Deposited  in 1 transaction";
        else if (amount<0)
            return "Negative amount cannot be added";
        return null;


    }
    public String error3(double amount,BankAccount account)                         //exception for transfer between two accounts
    {
        if(amount>account.balance)
            return "You are not having sufficent amount  ";
        else  if(amount>50000)
            return "very large amount to Deposited  in 1 transaction";
        else if (amount<0)
            return "Negative amount cannot be added";
        return null;
    }



}
public class BankingSystem extends BankingException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();                 //list containing all the instances of BankAccount class
        List<Transaction> transactions = new ArrayList<>();
//adding bank account to the System
        BankAccount ac1 = new BankAccount("7018124745", 1500);
        BankAccount ac2 = new BankAccount("8894224032", 2000);
        BankAccount ac3 = new BankAccount("7876789711", 5000);
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        while (true) {

            System.out.println("        OPTIONS          ");
            System.out.println("1: For Deposit");
            System.out.println("2: For Withdrawl");
            System.out.println("3. Transfer between tow accounts :");
            System.out.println("4. Display the Bank Account Details");
            System.out.println("5. Exit The system");
            try {                                                       //exception handling for wrong Input of choice
                System.out.println("Enter Your Choice:");
                int choice = sc.nextByte();
                if(choice>5)
                {
                    throw new InputMismatchException();
                }

                switch (choice) {
                    case 1:
                        deposit(sc, accounts);
                        break;
                    case 2:
                        withdraw(sc, accounts);
                        break;
                    case 3:
                        transfer(sc, accounts);
                        break;
                    case 4:
                        displayacc(sc,accounts);
                        break;
                    case 5:
                        System.out.println("Existing System");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input (SELECT A VALID OPTION) ");
            }
            sc.nextLine();
        }
    }

    public static void deposit(Scanner sc, List<BankAccount> accounts) {                //function for deposit amount in Bank account
        System.out.println("Enter account Number:");
        String acc = sc.next();
        boolean flag = false;
        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc)) {
                flag = true;
                System.out.println("Enter the amount you want to deposit:");
                double amount = sc.nextDouble();
                try {                                                           //catching various exception under Depisted amount
                    if (amount > 50000) {
                        throw new BankingException();
                    } else if (amount < 0) {
                        throw new BankingException();

                    } else {
                        account.balance += amount;
                        System.out.println("Updated Balance is : " + account.balance);
                        System.out.println("Amount is Deposited Successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println();
                } catch (BankingException e) {
                    System.out.println(e.error2(amount, account));
                }
            }
        }
        if (!flag)
            System.out.println("Account Number does not Exist \nPlase Enter a VALID Account Number");


    }

    public static void withdraw(Scanner sc, List<BankAccount> accounts) {               //function to withdraw amount for Bank account
        System.out.println("Enter account Number:");
        String acc = sc.next();
        boolean flag = false;
        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc)) {
                flag = true;
                System.out.println("Enter the amount you want to withdraw:");
                double amount = sc.nextDouble();
                try {                                                           //catching Various withdraw amount exceptions

                    if (amount > account.balance) {

                        throw new BankingException();
                    } else if (amount > 10000) {
                        throw new BankingException();
                    } else if (amount < 0) {
                        throw new BankingException();
                    } else {
                        account.balance -= amount;

                        System.out.println("Amount Successfully withdrawn\nAmount After withdraw :"+account.balance);
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Wrong  Input Type of amount");
                } catch (BankingException e) {

                    System.out.println(e.error1(amount, account));
                }

            }
        }
        if (!flag) {
            System.out.println("Enter a Valid account Number");
        }
    }

    public static void transfer(Scanner sc, List<BankAccount> accounts) {                       //function to transfer amount among bank accounts
        System.out.println("Enter the Account No from where Your want to Tranfer Money");
        String acc1 = sc.next();
        sc.nextLine();
        System.out.println("Enter the Account no to where you want Transfer ");
        String acc2 = sc.next();
        sc.nextLine();
        int flag = 0;
        BankAccount a = new BankAccount(), b = new BankAccount();
        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc1)) {
                flag += 1;
                a = account;
            }
        }
        for (BankAccount account : accounts) {
            if (Objects.equals(account.bankAccount, acc2)) {
                flag += 1;
                b = account;

            }
        }
        if (flag == 2) {
            System.out.println("Enter the amount you want to transfer");
            double amount = sc.nextInt();
            try {                                               //Catching various exception in transferring amount among accounts
                if (amount > a.balance) {
                    throw new BankingException();
                } else if (amount < 0) {
                    throw new BankingException();
                } else if (amount > 50000) {
                    throw new BankingException();

                }
                else {
                    a.balance -= amount;
                    b.balance += amount;
                    System.out.println("Amount Is transferred Successfully");
                }
            } catch (BankingException e) {
                System.out.println(e.error3(amount, a));
            }
        }
        else
        {
            System.out.println("Accounts does not exist ");
        }
    }
    public static void displayacc(Scanner sc,List<BankAccount> accounts)            //display the details of BankAccount
    {
        System.out.println("Enter your Bank account Number");
        String acc= sc.next();
        boolean flag=false;
        for(BankAccount account:accounts)
        {
            if(Objects.equals(account.bankAccount, acc))
            {
                System.out.println("Account Number :"+account.bankAccount+"\nBalance : "+account.balance);
                flag=true;
                break;
            }

        }
        if(!flag)
        {
            System.out.println("Please enter a valid Account Number");
        }
    }
}
