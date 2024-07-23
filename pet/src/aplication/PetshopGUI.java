package aplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetshopGUI {
    private Petshop petshop;
    private JFrame frame;
    private JTextField nomeClienteField;
    private JTextField telefoneClienteField;
    private JTextField nomePetField;
    private JTextField tipoPetField;
    private JTextArea displayArea;

    public PetshopGUI() {
        petshop = new Petshop();
        frame = new JFrame("Cadastro de Clientes - Petshop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel nomeClienteLabel = new JLabel("Nome do Cliente:");
        nomeClienteField = new JTextField();
        JLabel telefoneClienteLabel = new JLabel("Telefone do Cliente:");
        telefoneClienteField = new JTextField();
        JLabel nomePetLabel = new JLabel("Nome do Pet:");
        nomePetField = new JTextField();
        JLabel tipoPetLabel = new JLabel("Tipo do Pet:");
        tipoPetField = new JTextField();

        panel.add(nomeClienteLabel);
        panel.add(nomeClienteField);
        panel.add(telefoneClienteLabel);
        panel.add(telefoneClienteField);
        panel.add(nomePetLabel);
        panel.add(nomePetField);
        panel.add(tipoPetLabel);
        panel.add(tipoPetField);

        JButton cadastrarButton = new JButton("Cadastrar Cliente");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        JButton listarButton = new JButton("Listar Clientes");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClientes();
            }
        });

        panel.add(cadastrarButton);
        panel.add(listarButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void cadastrarCliente() {
        String nomeCliente = nomeClienteField.getText();
        String telefoneCliente = telefoneClienteField.getText();
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);

        String nomePet = nomePetField.getText();
        String tipoPet = tipoPetField.getText();
        Pet pet = new Pet(nomePet, tipoPet);
        cliente.addPet(pet);

        petshop.cadastrarCliente(cliente);
        clearFields();
    }

    private void listarClientes() {
        displayArea.setText("");
        for (Cliente cliente : petshop.getClientes()) {
            displayArea.append(cliente.toString() + "\n");
        }
    }

    private void clearFields() {
        nomeClienteField.setText("");
        telefoneClienteField.setText("");
        nomePetField.setText("");
        tipoPetField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PetshopGUI();
            }
        });
    }
}
