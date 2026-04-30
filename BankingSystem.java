
import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful");
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void display() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}

public class BankingSystem {

    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Banking System ====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    depositMoney(sc);
                    break;
                case 4:
                    withdrawMoney(sc);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void createAccount(Scanner sc) {
        sc.nextLine();

        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, name, balance);
        accounts.add(acc);

        System.out.println("Account Created Successfully");
    }

    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }

        for (Account acc : accounts) {
            acc.display();
        }
    }

    static void depositMoney(Scanner sc) {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        boolean found = false;

        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                found = true;
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                acc.deposit(amount);
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found");
        }
    }

    static void withdrawMoney(Scanner sc) {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        boolean found = false;

        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                found = true;
                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();
                acc.withdraw(amount);
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found");
        }
    }
}