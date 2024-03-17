import javax.swing.*;
import java.awt.*;
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
        setSize(600, 200);
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

    private Polynomial performOperation(String operation) {
        Polynomial poly1 = parsePolynomial(textField1.getText());
        Polynomial poly2 = parsePolynomial(textField2.getText());
        Polynomial result;

        switch (operation) {
            case "Addition":
                result = new Polynomial(Operations.addPolynomials(poly1.getTerms(), poly2.getTerms()));
                break;
            case "Subtraction":
                result = new Polynomial(Operations.subtractPolynomials(poly1.getTerms(), poly2.getTerms()));
                break;
            case "Multiplication":
                result = new Polynomial(Operations.multiplyPolynomials(poly1.getTerms(), poly2.getTerms()));
                break;
            case "Derivative":
                result = new Polynomial(Operations.derivative(poly1.getTerms()));
                break;
            case "Integration":
                result = new Polynomial(Operations.integrate(poly1.getTerms()));
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

        displayResult(result);
        return result;
    }

    private Polynomial parsePolynomial(String polynomial) {
        return PolynomialParser.parse(polynomial);
    }

    private void displayResult(Polynomial result) {
        resultTextField.setText(result.toString());
        if(resultTextField.getText().isEmpty())
            resultTextField.setText("0");
    }


    public static void main(String[] args) {
        try {
            // Set Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
