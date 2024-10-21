package com.cofrinho;

/**
 * A classe Dolar representa uma moeda do tipo Dólar.
 * 
 * <p>
 * Esta classe herda de {@link Moeda} e implementa os métodos abstratos para
 * exibir informações da moeda e converter o valor de Dólar para Real. O valor
 * de conversão utilizado é 1 Dólar = 5.00 Reais (este valor pode ser ajustado conforme necessário).
 * </p>
 */

public class Dolar extends Moeda {

    /**
     * Construtor da classe Dolar.
     * 
     * @param valor O valor da moeda em Dólares.
     */

    public Dolar(double valor) {
        super(valor);
    }

     /**
     * Exibe as informações da moeda.
     * <p>
     * Este método imprime o tipo da moeda (Dólar) e o valor da moeda em Dólares.
     * </p>
     */

    @Override
    public void info() {
        System.out.println("Dólar - Valor: $" + valor);
    }

    /**
     * Converte o valor da moeda de Dólar para Real.
     * <p>
     * O valor de conversão utilizado é 1 Dólar = 5.00 Reais. Este método retorna
     * o valor equivalente em Reais.
     * </p>
     * 
     * @return O valor convertido de Dólar para Real.
     */

    @Override
    public double converter() {
        return valor * 5.00;
    }
}

