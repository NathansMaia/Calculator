import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField display; // Campo de texto para mostrar a entrada e o resultado
    private JButton[] numberButtons; // Botões numéricos
    private JButton addButton, subButton, mulButton, divButton, equButton, clrButton; // Botões de operações
    private Font font = new Font("Arial", Font.PLAIN, 20); // Fonte para os botões

    public CalculatorGUI() {
        // Configuração da janela principal
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuração do campo de texto
        display = new JTextField();
        display.setEditable(false);
        display.setFont(font);
        display.setHorizontalAlignment(JTextField.LEFT);
        add(display, BorderLayout.NORTH);

        // Configuração do painel de botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3, 10, 10)); // 5 linhas, 3 colunas, espaçamento de 10 pixels

        numberButtons = new JButton[10];
        for (int i = 9; i >= 0; i--) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            panel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");

        // Configurando a fonte para os botões de operações
        JButton[] opButtons = {addButton, subButton, mulButton, divButton, equButton, clrButton};
        for (JButton button : opButtons) {
            button.setFont(font);
        }

        // Adicionando os botões de operações ao painel
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(equButton);
        panel.add(clrButton);

        add(panel, BorderLayout.CENTER);

        // Estilização adicional para tornar a interface mais bonita
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    // Métodos para adicionar ActionListeners aos botões
    public void addNumberButtonListener(int number, ActionListener listener) {
        numberButtons[number].addActionListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubButtonListener(ActionListener listener) {
        subButton.addActionListener(listener);
    }

    public void addMulButtonListener(ActionListener listener) {
        mulButton.addActionListener(listener);
    }

    public void addDivButtonListener(ActionListener listener) {
        divButton.addActionListener(listener);
    }

    public void addEquButtonListener(ActionListener listener) {
        equButton.addActionListener(listener);
    }

    public void addClrButtonListener(ActionListener listener) {
        clrButton.addActionListener(listener);
    }

    // Método para atualizar o display
    public void setDisplayText(String text) {
        display.setText(text);
    }

    // Método para obter o texto do display
    public String getDisplayText() {
        return display.getText();
    }
}
