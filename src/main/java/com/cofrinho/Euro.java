package com.cofrinho;

/**
 * A classe Euro representa uma moeda do tipo Euro.
 * 
 * <p>
 * Esta classe herda de {@link Moeda} e implementa os métodos abstratos para
 * exibir informações da moeda e converter o valor de Euro para Real. O valor
 * de conversão utilizado é 1 Euro = 6.00 Reais (este valor pode ser ajustado conforme necessário).
 * </p>
 */
public class Euro extends Moeda {

    /**
     * Construtor da classe Euro.
     * 
     * @param valor O valor da moeda em Euros.
     */
    public Euro(double valor) {
        super(valor);
    }

    /**
     * Exibe as informações da moeda.
     * <p>
     * Este método imprime o tipo da moeda (Euro) e o valor da moeda em Euros.
     * </p>
     */
    @Override
    public void info() {
        System.out.println("Euro: " + valor);
    }

    /**
     * Converte o valor da moeda de Euro para Real.
     * <p>
     * O valor de conversão utilizado é 1 Euro = 6.00 Reais. Este método retorna
     * o valor equivalente em Reais.
     * </p>
     * 
     * @return O valor convertido de Euro para Real.
     */
    @Override
    public double converter() {
        return valor * 6.00;
    }
}