import java.util.Scanner;

public class Main {

    private static Bank bank = new Bank("DSL");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addBankBranch();
        bank.printBranches();
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

}
