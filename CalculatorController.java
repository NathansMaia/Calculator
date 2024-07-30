import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private Calculator model;
    private CalculatorGUI view;
    private double tempNumber; 
    // Variável para armazenar o número temp
    private String operator; 
    // Variável para armazenar o operador

    public CalculatorController(Calculator model, CalculatorGUI view) {
        this.model = model;
        this.view = view;
        this.tempNumber = 0;
        this.operator = "";
        
        for (int i = 0; i < 10; i++) {
            final int index = i;
            view.addNumberButtonListener(i, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    view.setDisplayText(view.getDisplayText() + index);
                }
            });
        }
        view.addAddButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operatorPressed("+");
            }
        });

        view.addSubButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operatorPressed("-");
            }
        });

        view.addMulButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operatorPressed("*");
            }
        });

        view.addDivButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operatorPressed("/");
            }
        });

        view.addEquButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equalsPressed();
            }
        });

        view.addClrButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.setDisplayText("");
                tempNumber = 0;
                operator = "";
            }
        });
    }

    // Processar a operação do operador
    private void operatorPressed(String op) {
        tempNumber = Double.parseDouble(view.getDisplayText());
        operator = op;
        view.setDisplayText("");
    }

    // Processar a operação de igualdade
    private void equalsPressed() {
        double secondNumber = Double.parseDouble(view.getDisplayText());
        double result = 0;

        try {
            switch (operator) {
                case "+":
                    result = model.add(tempNumber, secondNumber);
                    break;
                case "-":
                    result = model.subtract(tempNumber, secondNumber);
                    break;
                case "*":
                    result = model.multiply(tempNumber, secondNumber);
                    break;
                case "/":
                    result = model.divide(tempNumber, secondNumber);
                    break;
            }
            view.setDisplayText(String.valueOf(result));
        } catch (ArithmeticException e) {
            view.setDisplayText("Erro");
        }

        tempNumber = 0;
        operator = "";
    }
}
