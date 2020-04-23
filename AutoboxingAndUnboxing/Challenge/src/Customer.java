import java.util.ArrayList;

public class Customer {
    private String CustomerName;
    private String AccountNumber;
    private ArrayList<Double> Transactions;

    public Customer(String customerName, String accountNumber, ArrayList<Double> transactions) {
        this.CustomerName = customerName;
        this.AccountNumber = accountNumber;
        this.Transactions = transactions;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public ArrayList<Double> getTransactions() {
        return Transactions;
    }

    public static Customer createCustomer (String customerName, String accountNumber, ArrayList<Double> Transactions) {
        return new Customer(customerName, accountNumber, Transactions);
    }
}
