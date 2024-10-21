package com.cofrinho;

import java.util.Scanner;

/**
 * Classe principal que implementa o sistema de gerenciamento de um cofrinho de moedas.
 * 
 * <p>
 * Este programa simula um cofrinho que permite ao usuário adicionar moedas de diferentes
 * tipos (Dólar, Euro, Real), remover uma quantidade específica de uma moeda e listar todas
 * as moedas presentes no cofrinho. Além disso, o programa pode calcular o valor total
 * convertido para Reais de todas as moedas armazenadas.
 * </p>
 * 
 * <p>
 * A interação com o usuário é realizada por meio de um menu de opções que inclui:
 * </p>
 * <ul>
 * <li>Adicionar uma moeda ao cofrinho, especificando o tipo e o valor da moeda.</li>
 * <li>Remover uma quantidade específica de uma moeda existente no cofrinho.</li>
 * <li>Listar todas as moedas presentes no cofrinho.</li>
 * <li>Calcular o valor total de todas as moedas convertidas em Reais.</li>
 * <li>Encerrar o programa.</li>
 * </ul>
 * 
 * <p>
 * O programa continua executando até que o usuário escolha a opção de sair.
 * </p>
 */

public class Main {
    /**
     * Método principal que inicia a aplicação de gerenciamento do cofrinho.
     * <p>
     * O usuário interage com um menu que permite adicionar moedas, remover
     * valores de moedas, listar todas as moedas e calcular o valor total convertido
     * em Reais. O loop do menu continua até que o usuário selecione a opção de sair.
     * </p>
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Listar moedas");
            System.out.println("4 - Calcular valor total convertido para Real");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarMoeda(scanner, cofrinho);
                    break;
                case 2:
                    removerMoeda(scanner, cofrinho);
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.printf("Total convertido para Real: R$%.2f%n", cofrinho.totalConvertido());
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }

     /**
     * Adiciona uma moeda ao cofrinho com base na escolha do usuário.
     * <p>
     * Este método apresenta ao usuário uma lista de tipos de moedas (Dólar, Euro, Real)
     * e solicita o valor da moeda a ser adicionada. A moeda correspondente é então 
     * criada e adicionada ao cofrinho.
     * </p>
     * 
     * @param scanner  O objeto Scanner usado para obter a entrada do usuário.
     * @param cofrinho O objeto Cofrinho onde a moeda será adicionada.
     */
    private static void adicionarMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Escolha a moeda:");
        System.out.println("1 - Dólar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();

        System.out.println("Informe o valor:");
        double valor = scanner.nextDouble();
        
        switch (tipoMoeda) {
            case 1:
                cofrinho.adicionar(new Dolar(valor));
                break;
            case 2:
                cofrinho.adicionar(new Euro(valor));
                break;
            case 3:
                cofrinho.adicionar(new Real(valor));
                break;
            default:
                System.out.println("Moeda inválida.");
        }
    }

    /**
     * Remove um valor específico de uma moeda existente no cofrinho.
     * <p>
     * Este método permite que o usuário escolha o tipo de moeda (Dólar, Euro, Real)
     * e o valor que ele deseja subtrair do saldo total dessa moeda. Se a moeda com o
     * valor especificado existir e tiver saldo suficiente, o valor será subtraído da moeda.
     * Caso contrário, uma mensagem de erro será exibida.
     * </p>
     * 
     * @param scanner  O objeto Scanner usado para obter a entrada do usuário.
     * @param cofrinho O objeto Cofrinho de onde o valor será subtraído.
     */

    private static void removerMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Escolha a moeda para subtrair valor:");
        System.out.println("1 - Dólar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();
    
        System.out.println("Informe o valor da moeda a subtrair:");
        double valor = scanner.nextDouble();
        Moeda moedaParaRemover = null;
    
        switch (tipoMoeda) {
            case 1:
                moedaParaRemover = new Dolar(0); // Passando 0 pois o valor será ajustado pelo método de remoção
                break;
            case 2:
                moedaParaRemover = new Euro(0); 
                break;
            case 3:
                moedaParaRemover = new Real(0); 
                break;
            default:
                System.out.println("Moeda inválida.");
                return;
        }
    
        // Tenta subtrair o valor da moeda no cofrinho
        boolean sucesso = cofrinho.remover(moedaParaRemover, valor);
        if (!sucesso) {
            System.out.println("Não foi possível subtrair o valor da moeda. Verifique se ela existe no cofrinho ou se há saldo suficiente.");
        }
    }
}