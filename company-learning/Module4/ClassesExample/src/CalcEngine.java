public class CalcEngine {

    public static void main(String[] args) {
        MathEquations[] Equations = new MathEquations[4];
        Equations[0] = create(20.0d, 2693.567d, 'd');
        Equations[1] = create(120.0d, 33.4d, 'm');
        Equations[2] = create(576.0d, 5.4d, 'a');
        Equations[3] = create(190.0d, 47.8d, 's');

        for (MathEquations Equation : Equations) {
            Equation.execute();
        }
    }
    private static MathEquations create(double leftVal, double rightVal, char opCode) {
        return new MathEquations(leftVal, rightVal, opCode);
    }
}
