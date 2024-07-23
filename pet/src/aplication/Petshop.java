package aplication;

import java.util.ArrayList;

public class Petshop {
    private ArrayList<Cliente> clientes;

    public Petshop() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}