import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
    private String BranchName;
    private ArrayList<Customer> branchCustomers;
    private Scanner scanner = new Scanner(System.in);

    public Branch(String branchName) {
        BranchName = branchName;
        this.branchCustomers = new ArrayList<>();
    }

    public String getBranchName() {
        return this.BranchName;
    }

    private ArrayList<Customer> getBranchCustomers() {
        return this.branchCustomers;
    }

    public static Branch createBranch(String branchName) {
        return new Branch(branchName);
    }

    private int findCustomer(Customer customer) {
        return this.branchCustomers.indexOf(customer);
    }

    private int findCustomer(String customerName) {
        for (int i=0; i<this.branchCustomers.size(); i++) {
            Customer customer = this.branchCustomers.get(i);
            if (customer.getCustomerName().equals(customerName)) {
                System.out.println("Customer with name " + customerName +" in this branch exists");
                return i;
            }
        }
        return -1;
    }

    public boolean addBranchCustomer(Customer customer) {
        if (findCustomer(customer.getCustomerName()) >=0) {
            return false;
        }
        branchCustomers.add(customer);
        return true;
    }

    public void listBranchCustomers(Branch branch) {
        for (int i=0; i<branch.getBranchCustomers().size(); i++) {
            System.out.print("\t" + this.branchCustomers.get(i).getCustomerName());
            System.out.print("\t" + this.branchCustomers.get(i).getAccountNumber() + "\n");
        }
    }

    public void addBranchCustomerTransaction() {
        System.out.println("Enter the customer name: ");
        String name = scanner.nextLine();
        int position = findCustomer(name);
        if (position >= 0) {
            Customer customer = this.branchCustomers.get(position);
            System.out.println("Enter the transaction amount to be added: ");
            Double amount = scanner.nextDouble();
            scanner.nextLine();
            customer.addCustomerTransactions(amount);
        } else {
            System.out.println("Customer " + name + " not found in this branch");
        }
    }

    public void listBranchCustomerTransactions() {
        System.out.println("Enter the customer name: ");
        String name = scanner.nextLine();
        int position = findCustomer(name);
        if (position >= 0) {
            Customer customer = this.branchCustomers.get(position);
            customer.getCustomerTransactionDetails();
        } else {
            System.out.println("Customer " + name + " not found in this branch");
        }
    }
}
