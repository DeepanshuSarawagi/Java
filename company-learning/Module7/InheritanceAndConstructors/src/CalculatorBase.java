public abstract class CalculatorBase {
    private double LeftVal;
    private double RightVal;
    private double Result;

    public double getLeftVal() {
        return LeftVal;
    }

    public double getRightVal() {
        return RightVal;
    }

    public double getResult() {
        return Result;
    }

    public void setLeftVal(double leftVal) {
        LeftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        RightVal = rightVal;
    }

    public void setResult(double result) {
        Result = result;
    }

    public CalculatorBase() {

    }

    public CalculatorBase (double LeftVal, double RightVal) {
        this.LeftVal = LeftVal;
        this.RightVal = RightVal;
    }

    public abstract void calculate();
}

class Adder extends CalculatorBase {
    public Adder() {

    }

    public Adder(double LeftVal, double RightVal) {
        super(LeftVal, RightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() + super.getRightVal();
        super.setResult(value);
    }
}

class Subtracter extends CalculatorBase {
    public Subtracter() {

    }

    public Subtracter(double LeftVal, double RightVal) {
        super(LeftVal, RightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() - super.getRightVal();
        super.setResult(value);
    }
}

class Multiplier extends CalculatorBase {

    public Multiplier() {

    }

    public Multiplier(double LeftVal, double RightVal) {
        super(LeftVal, RightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() * super.getRightVal();
        super.setResult(value);
    }
}

class Divider extends CalculatorBase{
    public Divider() {

    }

    public Divider(double LeftVal, double RightVal) {
        super(LeftVal, RightVal);
    }

    @Override
    public void calculate() {
        double value = super.getLeftVal() / super.getRightVal();
        super.setResult(value);
    }
}
