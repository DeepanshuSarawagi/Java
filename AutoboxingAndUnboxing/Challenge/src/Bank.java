import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String bankName;
    private ArrayList<Branch> bankBranches;
    private Scanner scanner = new Scanner(System.in);

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankBranches = new ArrayList<>();
    }
    public String getBankName() {
        return this.bankName;
    }

    public boolean addBankBranches(Branch branchName) {
        if (findBankBranches(branchName.getBranchName()) >= 0) {
            return false;
        }
        bankBranches.add(branchName);
        return true;
    }

    private int findBankBranches(Branch branch) {
        return this.bankBranches.indexOf(branch);
    }

    private int findBankBranches(String branchName) {
        for (int i=0; i<this.bankBranches.size(); i++) {
            Branch branch = this.bankBranches.get(i);
            if (branch.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void printBranches() {
        for (int i=0; i<this.bankBranches.size(); i++) {
            System.out.println((i+1) + ". " + this.bankBranches.get(i).getBranchName());
        }
    }

    public void addBranchCustomer() {
        System.out.println("Enter the customer name to be added: ");
        String name = scanner.nextLine();
        System.out.println("Enter the customer account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the branch name where customer needs to be added.");
        String branchName = scanner.nextLine();
        int bankBranchIndex = findBankBranches(branchName);
        if (bankBranchIndex >= 0) {
            Branch branch = this.bankBranches.get(bankBranchIndex);
            Customer customer = Customer.createCustomer(name, accountNumber, 1000.0);
            if (branch.addBranchCustomer(customer)) {
                System.out.println("Customer successfully added.");
            } else {
                System.out.println("Customer in this branch already exists");
            }
        } else {
            System.out.println("Branch not found");
        }
    }

    public void listBranchCustomers() {
        printBranches();
        System.out.println("Enter the branch name whose customers have to be listed: ");
        String branchName = scanner.nextLine();
        int bankBranchIndex = findBankBranches(branchName);
        if (bankBranchIndex >= 0) {
            Branch branch = this.bankBranches.get(bankBranchIndex);
            branch.listBranchCustomers(branch);
        } else {
            System.out.println("Branch " + branchName + " not found");
        }
    }

    public Branch queryBranchName(String name) {
        int position = findBankBranches(name);
        if (position < 0) {
            return null;
        }
        return this.bankBranches.get(position);
    }

    public boolean addBranchCustomerTransactions() {
        System.out.println("Enter the branch name where customer resides: ");
        String branchName = scanner.nextLine();
        int position = findBankBranches(branchName);
        if (position >= 0) {
            Branch branch = this.bankBranches.get(position);
            branch.addBranchCustomerTransaction();
            return true;
        }
        System.out.println("Branch name not found");
        return false;
    }

    public void listBranchCustomerTransactions() {
        System.out.println("Enter the branch name where customer resides: ");
        String branchName = scanner.nextLine();
        int position = findBankBranches(branchName);
        if (position >= 0) {
            Branch branch = this.bankBranches.get(position);
            branch.listBranchCustomerTransactions();
            return;
        }
        System.out.println("Branch name not found");
    }
}
