import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4 {
    private String accountNumber;
    private String accountHolderName;
    private double accountBalance;
    private List<Transaction> transactionList;

    public Lab4() {
        transactionList = new ArrayList<Transaction>();
    }

    public void initializeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        accountNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        accountHolderName = scanner.next();
        System.out.print("Enter account balance: ");
        accountBalance = scanner.nextDouble();
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        accountBalance += depositAmount;
        transactionList.add(new Transaction("Deposit", depositAmount));
        System.out.println("Deposit successful!");
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        if (withdrawalAmount > accountBalance) {
            System.out.println("Insufficient balance!");
            return;
        }
        accountBalance -= withdrawalAmount;
        transactionList.add(new Transaction("Withdrawal", withdrawalAmount));
        System.out.println("Withdrawal successful!");
    }

    public void printTransactions() {
        if (transactionList.isEmpty()) {
            System.out.println("No transactions found!");
            return;
        }
        System.out.println("Transaction Details:");
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    public void printAccountSummary() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public static void main(String[] args) {
        Lab4 bankAccount = new Lab4();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Print Transactions");
            System.out.println("5. Print Account Summary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bankAccount.initializeCustomer();
                    break;
                case 2:
                    bankAccount.deposit();
                    break;
                case 3:
                    bankAccount.withdraw();
                    break;
                case 4:
                    bankAccount.printTransactions();
                    break;
                case 5:
                    bankAccount.printAccountSummary();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

class Transaction {
    private String type;
    private double amount;
    private String dateTime;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = java.time.LocalDateTime.now().toString();
    }

    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Date/Time: " + dateTime;
    }
}
