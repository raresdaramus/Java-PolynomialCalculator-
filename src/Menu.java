import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Menu extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton additionButton;
    private JButton subtractionButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton derivativeButton;
    private JButton integrationButton;
    private JTextField resultTextField;
    private JPanel Panel;

    public Menu() {
        setContentPane(Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setTitle("Polynomial Calculator");

        additionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Addition");
            }
        });

        subtractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Subtraction");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Multiplication");
            }
        });

        derivativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Derivative");
            }
        });

        integrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Integration");
            }
        });
    }

    private void performOperation(String operation) {
        Polynomial poly1 = parsePolynomial(textField1.getText());
        Polynomial poly2 = parsePolynomial(textField2.getText());

        Map<Integer, Double> result;

        switch (operation) {
            case "Addition":
                result = Operations.addPolynomials(poly1.getTerms(), poly2.getTerms());
                break;
            case "Subtraction":
                result = Operations.subtractPolynomials(poly1.getTerms(), poly2.getTerms());
                break;
            case "Multiplication":
                result = Operations.multiplyPolynomials(poly1.getTerms(), poly2.getTerms());
                break;
            case "Derivative":
                result = Operations.derivative(poly1.getTerms());
                break;
            case "Integration":
                result = Operations.integrate(poly1.getTerms());
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

        displayResult(result);
    }
    private Polynomial parsePolynomial(String polynomial) {
        return PolynomialParser.parse(polynomial);
    }


    private void displayResult(Map<Integer, Double> result) {
        StringBuilder resultText = new StringBuilder("Result:\n");

        for (Map.Entry<Integer, Double> entry : result.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            resultText.append(coefficient).append("x^").append(exponent).append("\n");
        }

        resultTextField.setText(resultText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
