package aplication;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;
    private ArrayList<Pet> pets;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.pets = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append(", Telefone: ").append(telefone).append("\nPets:\n");
        for (Pet pet : pets) {
            sb.append(pet).append("\n");
        }
        return sb.toString();
    }
}