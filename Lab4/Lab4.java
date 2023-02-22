import java.util.Scanner;

public class BankAccount {
    String accountNumber;
    String accountHolderName;
    double accountBalance;
    String[] transactions;
    int index;

    public BankAccount(String accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.transactions = new String[100];
        this.index = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.accountBalance += amount;
            this.transactions[this.index++] = String.format("Deposited $%.2f", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.accountBalance) {
            this.accountBalance -= amount;
            this.transactions[this.index++] = String.format("Withdrawn $%.2f", amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void printTransactions() {
        System.out.println("Transactions:");
        for (int i = 0; i < this.index; i++) {
            System.out.println(this.transactions[i]);
        }
    }

    public void printSummary() {
        System.out.println("Account Summary:");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
        System.out.println("Account Balance: $" + this.accountBalance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial account balance: ");
        double accountBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        BankAccount bankAccount = new BankAccount(accountNumber, accountHolderName, accountBalance);

        int choice;
        do {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Print transactions");
            System.out.println("4. Print account summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    bankAccount.printTransactions();
                    break;
                case 4:
                    bankAccount.printSummary();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
