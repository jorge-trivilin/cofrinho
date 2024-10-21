package com.cofrinho;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dólar - Valor: $" + valor);
    }

    @Override
    public double converter() {
        return valor * 5.00;
    }
}

