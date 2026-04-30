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
        balance = balance + amount;
        System.out.println("Deposit Successful");
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
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

public class Main {

    static ArrayList<Account> list = new ArrayList<Account>();

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

            if (choice == 1) {
                System.out.print("Enter Account No: ");
                int accNo = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Balance: ");
                double bal = sc.nextDouble();

                Account a = new Account(accNo, name, bal);
                list.add(a);

                System.out.println("Account Created!");
            }

            else if (choice == 2) {
                for (Account a : list) {
                    a.display();
                }
            }

            else if (choice == 3) {
                System.out.print("Enter Account No: ");
                int accNo = sc.nextInt();

                for (Account a : list) {
                    if (a.accNo == accNo) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        a.deposit(amt);
                    }
                }
            }

            else if (choice == 4) {
                System.out.print("Enter Account No: ");
                int accNo = sc.nextInt();

                for (Account a : list) {
                    if (a.accNo == accNo) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        a.withdraw(amt);
                    }
                }
            }

        } while (choice != 5);

        sc.close();
    }
}