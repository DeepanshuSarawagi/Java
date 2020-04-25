import java.util.Scanner;

public class Main {

    private static Bank bank = new Bank("DSL");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        listOptions();
        boolean quit = false;
        while (!quit) {
            System.out.println("Choose your options from the menu: ");
            int options = scanner.nextInt();
            scanner.nextLine();
            switch (options) {
                case 0:
                    startBankApp();
                    break;
                case 1:
                    listBankBranches();
                    break;
                case 2:
                    addBankBranch();
                    break;
                case 3:
                    addBranchCustomer();
                    break;
                case 4:
                    listBranchCustomers();
                    break;
                case 5:
                    queryBranch();
                    break;
                case 6:
                    addBranchCustomerTransactions();
                    break;
                case 7:
                    listBranchCustomerTransactions();
                    break;
                case 8:
                    listOptions();
                    break;
                case 9:
                    quit = true;
                    System.out.println("Exiting from bank app");
                    break;
            }


        }
    }

    private static void listOptions() {
        System.out.println("0-  Enter 0 to start bank app " + "\n" +
                           "1- Enter 1 to list bank branches" + "\n" +
                           "2- Enter 2 to add a bank branch " + "\n" +
                           "3- Enter 3 to add branch customers " + "\n" +
                           "4- Enter 4 to list branch customers" + "\n" +
                           "5- Enter 5 to query bank branch" + "\n" +
                           "6- Enter 6 to add a transaction for a customer" + "\n" +
                           "7- Enter 7 to list transaction for a customer" + "\n" +
                           "8- Enter 8 to print bank app menu" + "\n" +
                           "9- Enter 9 to quit bank application");
    }

    private static void listBankBranches() {
        bank.printBranches();
    }

    private static void startBankApp () {
        System.out.println("Initialising Bank app. Welcome to " + bank.getBankName() + " Bank!");
    }

    private static void addBankBranch() {
        System.out.println("enter the new branch name to be created: ");
        String name = scanner.nextLine();
        Branch branch = Branch.createBranch(name);
        if (bank.addBankBranches(branch)) {
            System.out.println("Bank branch " + name + " successfully created. ");
        } else {
            System.out.println("Branch " + name + " already exists.");
        }
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

    private static void addBranchCustomer() {
        bank.addBranchCustomer();
    }

    private static void addBranchCustomerTransactions() {
        if (bank.addBranchCustomerTransactions()) {
            System.out.println("Customer transaction successfully added.");
        } else {
            System.out.println("Customer transaction adding failed.");
        }
    }

    private static void listBranchCustomerTransactions() {
        bank.listBranchCustomerTransactions();
    }

}
