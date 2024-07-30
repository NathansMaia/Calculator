public class Calculator {
    // adição

    public double add(double a, double b) {
        return a + b;
    }

    // subtração

    public double subtract(double a, double b) {
        return a - b;
    }

    // multiplicação

    public double multiply(double a, double b) {
        return a * b;
    }

    // divisão

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}
