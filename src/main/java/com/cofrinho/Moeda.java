package com.cofrinho;

/**
 * A classe abstrata Moeda define o comportamento básico de uma moeda.
 * 
 * <p>
 * Esta classe é a base para diferentes tipos de moedas, como {@link Dolar}, {@link Euro}
 * e {@link Real}. Ela define os atributos e métodos comuns que todas as moedas compartilham,
 * como o valor da moeda, a exibição de informações e a conversão para Reais. 
 * As classes que herdam de {@link Moeda} devem implementar os métodos abstratos {@code info()} 
 * e {@code converter()} para fornecer o comportamento específico de cada moeda.
 * </p>
 */
public abstract class Moeda {

    /**
     * O valor da moeda.
     */
    protected double valor;

    /**
     * Construtor da classe Moeda.
     * 
     * @param valor O valor da moeda.
     */
    public Moeda(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor da moeda.
     * 
     * @return O valor da moeda.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método abstrato para exibir as informações da moeda.
     * <p>
     * Este método deve ser implementado pelas subclasses para exibir o tipo
     * da moeda e o valor correspondente.
     * </p>
     */
    public abstract void info();

    /**
     * Método abstrato para converter o valor da moeda para Real.
     * <p>
     * Este método deve ser implementado pelas subclasses para fornecer a lógica
     * de conversão específica para cada tipo de moeda.
     * </p>
     * 
     * @return O valor convertido para Reais.
     */
    public abstract double converter();

    /**
     * Subtrai um valor da moeda, se o valor for menor ou igual ao saldo atual da moeda.
     * <p>
     * Se o valor a ser subtraído for maior que o saldo da moeda, uma mensagem de erro é exibida.
     * </p>
     * 
     * @param valor O valor a ser subtraído da moeda.
     */
    public void subtrairValor(double valor) {
        if (valor <= this.valor) {
            this.valor -= valor;
        } else {
            System.out.println("Valor de subtração maior do que o valor da moeda.");
        }
    }

    /**
     * Compara se duas moedas são iguais com base no valor e no tipo da moeda.
     * <p>
     * Duas moedas são consideradas iguais se tiverem o mesmo tipo (classe)
     * e o mesmo valor.
     * </p>
     * 
     * @param obj O objeto a ser comparado.
     * @return {@code true} se as moedas forem do mesmo tipo e tiverem o mesmo valor, 
     *         {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0;
    }

    /**
     * Retorna o código hash da moeda, com base no valor.
     * <p>
     * Este método garante que as moedas com o mesmo valor tenham o mesmo código
     * hash, facilitando a comparação em coleções que utilizam hashing.
     * </p>
     * 
     * @return O código hash baseado no valor da moeda.
     */
    @Override
    public int hashCode() {
        return Double.hashCode(valor);
    }
}