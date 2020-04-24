import java.util.Scanner;

public class Main {

    private static Bank bank = new Bank("DSL");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addBankBranch();
        addBankBranch();
        addBankBranch();
        queryBranch();
        bank.printBranches();
        bank.addBranchCustomer();
        bank.addBranchCustomer();
        bank.addBranchCustomer();
        bank.addBranchCustomer();
        listBranchCustomers();

    }

    private static void addBankBranch() {
        System.out.println("enter the new branch name to be created: ");
        String name = scanner.nextLine();
        Branch branch = Branch.createBranch(name);
        if (bank.addBankBranches(branch)) {
            System.out.println("Bank branch" + name + " successfully created. ");
        } else {
            System.out.println("Branch " + name + " already exists.");
        }
    }
    private static void findBankBranch() {
        System.out.println("Enter the bank branch to query");
        String name = scanner.nextLine();

    }

    private static void listBranchCustomers() {
        bank.listBranchCustomers();
    }

    private static void queryBranch() {
        System.out.println("Enter the branch name to search for: ");
        String name = scanner.nextLine();
        Branch existingBranch = bank.queryBranchName(name);
        if (existingBranch == null) {
            System.out.println("branch not found");
            return;
        }
        System.out.println("Branch " + existingBranch.getBranchName() + " found");
    }

}
