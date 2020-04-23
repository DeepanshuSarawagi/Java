import java.util.ArrayList;

public class Branch {
    private String BranchName;
    private ArrayList<Customer> branchCustomers;

    public Branch(String branchName) {
        BranchName = branchName;
        this.branchCustomers = new ArrayList<>();
    }

    public String getBranchName() {
        return this.BranchName;
    }

    public ArrayList<Customer> getBranchCustomers() {
        return this.branchCustomers;
    }

    public static Branch createBranch(String branchName) {
        return new Branch(branchName);
    }
}
