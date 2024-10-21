package com.cofrinho;

import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> moedas;

    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }

    // Adicionar moeda
    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada: " + moeda.getValor() + " " + moeda.getClass().getSimpleName());
    }

    public boolean remover(Moeda moeda, double valor) {
        for (Moeda m : moedas) {
            if (m.getClass() == moeda.getClass()) { // Encontramos o tipo certo de moeda
                if (m.getValor() >= valor) {
                    m.subtrairValor(valor);
                    System.out.println("Subtraído " + valor + " da moeda " + m.getClass().getSimpleName());
                    return true;
                } else {
                    System.out.println("Não há saldo suficiente para subtrair.");
                    return false;
                }
            }
        }
        System.out.println("Moeda não encontrada.");
        return false;
    }

    // Listar moedas
    public void listagemMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("Cofrinho vazio.");
            return;
        }

        System.out.println("Moedas no cofrinho:");
        for (Moeda moeda : moedas) {
            moeda.info();
        }
    }

    // Calcular valor total em Real
    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converter();
        }
        return total;
    }
}
