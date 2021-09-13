public class IfElseExample {

    public static void main(String[] args) {
        int v1 = 10;
        int v2 = 4;
        if (v1 > v2) {
            System.out.println("V1 is bigger");
        } else {
            System.out.println("V2 is bigger");
        }
        BlockStatements BS = new BlockStatements();
        BS.BlockStatementsExample();
    }
}

class BlockStatements {
    protected void BlockStatementsExample() {
        int v1 = 40, v2 = 10, diff;
        if (v1 > v2) {
            System.out.println("V1 is bigger");
            diff = v1 - v2;
        } else {
            System.out.println("v2 is bigger");
            diff = v2 - v1;
        }
        System.out.println("Diff is " + diff);
    }
}
