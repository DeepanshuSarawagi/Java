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
            System.out.println("Customer in this branch already exists");
            return false;
        }
        branchCustomers.add(customer);
        return true;
    }

    public void listBranchCustomers(Branch branch) {
        for (int i=0; i<branch.getBranchCustomers().size(); i++) {
            System.out.println(branchCustomers.get(i).getCustomerName());
            System.out.println(branchCustomers.get(i).getTransactions());
        }
    }

    public void addBranchCustomerTransaction() {
        System.out.println("Enter the customer name to be found: ");
        String name = scanner.nextLine();
        int position = findCustomer(name);
        Customer customer = this.branchCustomers.get(position);
        System.out.println("Enter the transaction amount to be added: ");
        Double amount = scanner.nextDouble();
        scanner.nextLine();
        customer.addCustomerTransactions(amount);
    }
}
