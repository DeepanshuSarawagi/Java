public class Main {
    public static void main(String[] args) {
        Flight F = new Flight(175);
        CargoFlight CF = new CargoFlight(580.45, 275);

        CalculatorBase[] calculators = {
                new Divider(100.0d, 25.0d),
                new Subtracter(100.0d, 25.0d),
                new Multiplier(100.0d, 25.0d),
                new Adder(100.0d, 25.0d)
        };

        for(CalculatorBase calculator:calculators) {
            calculator.calculate();
            System.out.println("Result = " + calculator.getResult());
        }
    }
}
