package OnilneBankingManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Online Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Account Number: ");
                    int acc = sc.nextInt();
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    bank.createAccount(acc, cid, name);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    acc = sc.nextInt();
                    System.out.print("Amount: ");
                    double dep = sc.nextDouble();
                    bank.deposit(acc, dep);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    acc = sc.nextInt();
                    System.out.print("Amount: ");
                    double wd = sc.nextDouble();
                    bank.withdraw(acc, wd);
                    break;

                case 4:
                    System.out.print("From Account: ");
                    int from = sc.nextInt();
                    System.out.print("To Account: ");
                    int to = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bank.transfer(from, to, amt);
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    acc = sc.nextInt();
                    bank.showBalance(acc);
                    break;

                case 6:
                    System.out.print("Account Number: ");
                    acc = sc.nextInt();
                    bank.showTransactions(acc);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

