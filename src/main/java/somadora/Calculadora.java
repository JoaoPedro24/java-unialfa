package somadora;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Calculadora extends JFrame {
    private JTextField campoValor1;
    private JTextField campoValor2;
    private JButton botaoSomar;

    public Calculadora() {
        setTitle("Calculadora que só Soma");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome = new JLabel("Valor 1:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelNome, constraints);

        campoValor1 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(campoValor1, constraints);

        labelNome = new JLabel("Valor 2:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(labelNome, constraints);

        campoValor2 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(campoValor2, constraints);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> somar());
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(botaoSomar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }
    private void validarNumero() throws NumberFormatException {
        if (campoValor1.getText().isEmpty())
            throw new RuntimeException(("Não pode ser vazio"));

        var numero = Integer.parseInt(campoValor1.getText());
        System.out.println(numero);
    }
    private void somar() {
        try {
            validarNumero();
            var valor1 = Integer.parseInt(campoValor1.getText());
            var valor2 = Integer.parseInt(campoValor2.getText());
            var total = valor1 + valor2;
            JOptionPane.showMessageDialog(this, "Resultado: " + total);

        } catch (NumberFormatException e) {
            System.out.println("Precisa ser apenas numeros");
            showMessageDialog(this, "Precisa ser apenas numeros");
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
            showMessageDialog(this, re.getMessage());
        }
    }
}
