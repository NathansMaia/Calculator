
public class Main {
    public static void main(String[] args) {
        
        Calculator model = new Calculator();
        CalculatorGUI view = new CalculatorGUI();
        CalculatorController controller = new CalculatorController(model, view);
        
        view.setVisible(true);
    }
}
