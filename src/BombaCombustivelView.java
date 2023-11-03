import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BombaCombustivelView {
    private JFrame frame;
    private JTextField textFieldValor;
    private JTextField textFieldLitros;
    private JTextArea textAreaResultado;
    private BombaCombustivelController controller;

    public BombaCombustivelView(BombaCombustivelController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Bomba de Combustível");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        JLabel labelValor = new JLabel("Valor a Abastecer:");
        textFieldValor = new JTextField(10);
        JButton buttonValor = new JButton("Abastecer por Valor");
        JLabel labelLitros = new JLabel("Litros a Abastecer:");
        textFieldLitros = new JTextField(10);
        JButton buttonLitros = new JButton("Abastecer por Litro");

        textAreaResultado = new JTextArea(10, 30);
        textAreaResultado.setEditable(false);

        buttonValor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abastecerPorValor();
            }
        });

        buttonLitros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abastecerPorLitro();
            }
        });

        panel.add(labelValor);
        panel.add(textFieldValor);
        panel.add(buttonValor);
        panel.add(labelLitros);
        panel.add(textFieldLitros);
        panel.add(buttonLitros);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textAreaResultado), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private void abastecerPorValor() {
        String valorText = textFieldValor.getText();
        try {
            double valor = Double.parseDouble(valorText);
            double litrosAbastecidos = controller.abastecerPorValor(valor);
            String resultado = String.format("Abastecidos %.2f litros por R$%.2f", litrosAbastecidos, valor);
            textAreaResultado.append(resultado + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Valor inválido. Insira um número válido.");
        }
    }

    private void abastecerPorLitro() {
        String litrosText = textFieldLitros.getText();
        try {
            double litros = Double.parseDouble(litrosText);
            double valorAbastecido = controller.abastecerPorLitro(litros);
            String resultado = String.format("Abastecido R$%.2f por %.2f litros", valorAbastecido, litros);
            textAreaResultado.append(resultado + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Litros inválidos. Insira um número válido.");
        }
    }
}
