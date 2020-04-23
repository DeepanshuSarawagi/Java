import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> bankBranches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankBranches = new ArrayList<>();
    }

    public boolean addBankBranches(Branch branchName) {
        if (findBankBranches(branchName.getBranchName()) >= 0) {
            System.out.println("Branch name already exists");
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
                System.out.println("Branch already exists");
                return i;
            }
        }
        return -1;
    }


}
