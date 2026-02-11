package OnilneBankingManagementSystem;

import java.util.*;

public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public Account createAccount(int accountNumber, int customerId, String name) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
            return null;
        }
        Customer customer = new Customer(customerId, name);
        Account account = new Account(accountNumber, customer);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
        return account;
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }
        account.deposit(amount);
        transactions.add(new Transaction(accountNumber, "DEPOSIT", amount));
        System.out.println("Amount deposited. New Balance: " + account.getBalance());
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (account.withdraw(amount)) {
            transactions.add(new Transaction(accountNumber, "WITHDRAW", amount));
            System.out.println("Withdrawal successful. New Balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid accounts.");
            return;
        }
        if (!sender.withdraw(amount)) {
            System.out.println("Insufficient balance.");
            return;
        }
        receiver.deposit(amount);
        transactions.add(new Transaction(fromAcc, "TRANSFER OUT", amount));
        transactions.add(new Transaction(toAcc, "TRANSFER IN", amount));

        System.out.println("Transfer successful.");
    }

    public void showBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Invalid account number.");
            return;
        }
        System.out.println("Balance: " + account.getBalance());
    }

    public void showTransactions(int accountNumber) {
        System.out.println("Transaction History:");
        for (Transaction t : transactions) {
            if (t.toString().contains(String.valueOf(accountNumber))) {
                System.out.println(t);
            }
        }
    }
}

