import java.util.*;

class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Rs. " + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("⚠️ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("💰 Current Balance: Rs. " + balance);
    }

    // Display account info
    public void accountInfo() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: Rs. " + balance);
        System.out.println("=======================");
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, BankAccount> accounts = new HashMap<>();

    // Create new account
    public static void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        sc.nextLine(); // consume newline
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("⚠️ Account number already exists!");
            return;
        }

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount newAccount = new BankAccount(name, accNo, balance);
        accounts.put(accNo, newAccount);

        System.out.println("🎉 Account created successfully!");
    }

    // Find account
    public static BankAccount getAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found!");
        }
        return acc;
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== BANKING SYSTEM MENU =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2: {
                    BankAccount acc = getAccount();
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                    }
                    break;
                }

                case 3: {
                    BankAccount acc = getAccount();
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        acc.withdraw(amt);
                    }
                    break;
                }

                case 4: {
                    BankAccount acc = getAccount();
                    if (acc != null) {
                        acc.checkBalance();
                    }
                    break;
                }

                case 5: {
                    BankAccount acc = getAccount();
                    if (acc != null) {
                        acc.accountInfo();
                    }
                    break;
                }

                case 6:
                    System.out.println("👋 Thank you for using the Banking System!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 6);
    }
}
