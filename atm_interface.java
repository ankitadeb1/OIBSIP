// User id: user123    User pin: pass123

import java.util.*;

// Represents the user's bank account
class BankAccount {
    private String userId;
    private String userPin;
    private double balance;

    // Initialize the bank account with user credentials and an opening balance
    public BankAccount(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
    }

    // Method to authenticate the user based on ID and PIN
    public boolean authenticate(String enteredId, String enteredPin) {
        return this.userId.equals(enteredId) && this.userPin.equals(enteredPin);
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw money if the balance is sufficient
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("You withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Amount must be positive.");
        }
        return false;
    }
}

// ATM interface for users
class ATM {
    private BankAccount account;

    // Link the ATM with the user's account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display menu and handle user actions
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

// Main class to run the program
public class atm_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined user ID and PIN for authentication
        String userId = "user123";
        String userPin = "pass123";

        // Create a bank account for the user with predefined credentials and an initial balance
        BankAccount userAccount = new BankAccount(userId, userPin, 1000.00);

        // Prompt the user for their ID and PIN
        System.out.print("Enter your User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter your User PIN: ");
        String enteredPin = scanner.nextLine();

        // Authenticate the user
        if (userAccount.authenticate(enteredId, enteredPin)) {
            System.out.println("Authentication successful! Welcome to the ATM.");
            ATM atm = new ATM(userAccount);
            atm.start();
        } else {
            System.out.println("Invalid User ID or PIN. Access denied.");
        }

        scanner.close();
    }
}
