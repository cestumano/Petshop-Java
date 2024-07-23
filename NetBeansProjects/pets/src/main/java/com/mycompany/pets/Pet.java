package com.mycompany.pets;

public class Pet {
    private String nome;
    private String tipo; // Ex: cachorro, gato, etc.

    public Pet(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Tipo: " + tipo;
    }
}