public class MathEquations {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    public MathEquations(double leftVal, double rightVal, char opCode) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
    }

    public double getLeftVal() {
        return this.leftVal;
    }

    public double getRightVal() {
        return this.rightVal;
    }

    public double getResult() {
        return this.result;
    }

    public void execute() {
        switch (this.opCode) {
            case 'a' -> {
                this.result = this.leftVal + this.rightVal;
                System.out.println(this.result);
            }
            case 's' -> {
                this.result = this.leftVal - this.rightVal;
                System.out.println(this.result);
            }
            case 'm' -> {
                this.result = this.leftVal * this.rightVal;
                System.out.println(this.result);
            }
            case 'd' -> {
                this.result = this.leftVal > 0.0d ? this.rightVal / this.leftVal : 0.0d;
                System.out.println(this.result);
            }
            default -> System.out.println("Unknown operation. Please try again");
        }
    }
}
