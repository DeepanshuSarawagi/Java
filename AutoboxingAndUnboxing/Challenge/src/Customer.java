import java.util.ArrayList;

public class Customer {
    private String CustomerName;
    private String AccountNumber;
    private ArrayList<Double> Transactions = new ArrayList<>();

    public Customer(String customerName, String accountNumber, double transactions) {
        this.CustomerName = customerName;
        this.AccountNumber = accountNumber;
        this.Transactions.add(transactions);
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

    public static Customer createCustomer (String customerName, String accountNumber, double transactions) {
        return new Customer(customerName, accountNumber, transactions);
    }

    public void addCustomerTransactions(Double transactions) {
        this.Transactions.add(transactions);
    }

    public void getCustomerTransactionDetails() {
        for (int i=0; i<this.Transactions.size(); i++) {
            System.out.println("\t" + "Transaction: " + Transactions.get(i));
        }
    }
}
