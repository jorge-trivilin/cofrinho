package com.cofrinho;

public abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract void info();

    public abstract double converter();


    public void subtrairValor(double valor) {
        if (valor <= this.valor) {
            this.valor -= valor;
        } else {
            System.out.println("Valor de subtração maior do que o valor da moeda.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(valor);
    }
}