package OnilneBankingManagementSystem;

import java.util.Date;

public class Transaction {
    private int accountNumber;
    private String type;
    private double amount;
    private Date date;

    public Transaction(int accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount;
    }
}
