package com.cofrinho;

/**
 * A classe Real representa uma moeda do tipo Real.
 * 
 * <p>
 * Esta classe herda de {@link Moeda} e implementa os métodos abstratos para
 * exibir informações da moeda e converter o valor de Real para Real (sem conversão).
 * Como o valor já está em Reais, o método de conversão simplesmente retorna o valor sem alterações.
 * </p>
 */
public class Real extends Moeda {

    /**
     * Construtor da classe Real.
     * 
     * @param valor O valor da moeda em Reais.
     */
    public Real(double valor) {
        super(valor);
    }

    /**
     * Exibe as informações da moeda.
     * <p>
     * Este método imprime o tipo da moeda (Real) e o valor da moeda em Reais.
     * </p>
     */
    @Override
    public void info() {
        System.out.println("Real: " + valor);
    }

    /**
     * Retorna o valor da moeda em Reais.
     * <p>
     * Como o valor já está em Reais, este método apenas retorna o valor da moeda
     * sem realizar nenhuma conversão adicional.
     * </p>
     * 
     * @return O valor da moeda em Reais.
     */
    @Override
    public double converter() {
        return valor;
    }
}