package com.cofrinho;

import java.util.ArrayList;

/**
 * A classe Cofrinho representa um cofrinho que armazena diferentes tipos de moedas.
 * 
 * <p>
 * A classe permite adicionar e remover moedas do cofrinho, listar todas as moedas armazenadas,
 * e calcular o valor total de todas as moedas convertidas para a moeda Real.
 * As moedas armazenadas são instâncias da classe abstrata {@link Moeda} e suas subclasses, 
 * como {@link Dolar}, {@link Euro} e {@link Real}.
 * </p>
 */

public class Cofrinho {
    private ArrayList<Moeda> moedas;

    /**
     * Construtor da classe Cofrinho.
     * <p>
     * Inicializa o cofrinho com uma lista vazia de moedas.
     * </p>
     */

    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova moeda ao cofrinho.
     * <p>
     * A moeda é adicionada à lista interna de moedas, e uma mensagem é exibida
     * confirmando a adição, com o valor da moeda e seu tipo (ex.: Dólar, Euro, Real).
     * </p>
     * 
     * @param moeda A moeda a ser adicionada, que deve ser uma instância de uma
     *              classe que herda de {@link Moeda}.
     */

    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada: " + moeda.getValor() + " " + moeda.getClass().getSimpleName());
    }

    /**
     * Subtrai um valor específico de uma moeda existente no cofrinho.
     * <p>
     * Este método encontra a moeda do tipo correspondente no cofrinho e, se o saldo
     * for suficiente, subtrai o valor indicado do saldo da moeda. Se o valor for maior 
     * que o saldo disponível, uma mensagem de erro é exibida.
     * </p>
     * 
     * @param moeda A moeda do tipo desejado para realizar a subtração (Dólar, Euro, Real).
     * @param valor O valor a ser subtraído do saldo da moeda.
     * @return {@code true} se o valor foi subtraído com sucesso, {@code false} se não havia
     *         saldo suficiente ou se a moeda não foi encontrada.
     */

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

    /**
     * Lista todas as moedas presentes no cofrinho.
     * <p>
     * O método exibe informações sobre todas as moedas armazenadas no cofrinho.
     * Se o cofrinho estiver vazio, uma mensagem informando isso será exibida.
     * </p>
     */

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

    /**
     * Calcula o valor total de todas as moedas no cofrinho convertidas para Real.
     * <p>
     * O método percorre todas as moedas do cofrinho e soma seus valores convertidos para Reais,
     * usando o método {@link Moeda#converter()} de cada moeda.
     * </p>
     * 
     * @return O valor total convertido em Reais de todas as moedas no cofrinho.
     */

    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converter();
        }
        return total;
    }
}
