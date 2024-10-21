# Cofrinho Java - Sistema de Gerenciamento de Moedas

## Descrição

Este projeto implementa um sistema simples de gerenciamento de moedas chamado **Cofrinho**. O programa permite que o usuário adicione, remova e liste diferentes tipos de moedas, como **Dólar**, **Euro** e **Real**, além de calcular o valor total convertido para a moeda **Real**.

O projeto foi desenvolvido em **Java** usando o **Maven** como ferramenta de build. Ele contém funcionalidades básicas de interação por meio de um menu no console, permitindo ao usuário manipular moedas e verificar o saldo total convertido.

## Funcionalidades

- Adicionar moedas de diferentes tipos (Dólar, Euro e Real).
- Remover um valor específico de uma moeda.
- Listar todas as moedas presentes no cofrinho.
- Calcular o valor total de todas as moedas convertidas para Reais.
- Sair do programa.

## Estrutura do Projeto

```plaintext
repo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── cofrinho/
│   │               ├── Cofrinho.java
│   │               ├── Moeda.java
│   │               ├── Dolar.java
│   │               ├── Euro.java
│   │               └── Real.java
├── pom.xml
└── README.md
```

- **`Cofrinho.java`**: Classe que gerencia as operações de adição, remoção e listagem de moedas.
- **`Moeda.java`**: Classe abstrata que define o comportamento comum de todas as moedas.
- **`Dolar.java`**, **`Euro.java`**, **`Real.java`**: Subclasses de `Moeda`, que implementam os métodos específicos de cada moeda.
- **`pom.xml`**: Arquivo de configuração do Maven.

## Requisitos

- **Java 11** ou superior (preferencialmente Java 17).
- **Maven** para build e gerenciamento de dependências.

## Como Rodar o Projeto

### 1. Clonar o Repositório

Clone o repositório do projeto para o seu ambiente local:

```bash
git clone https://github.com/seu-usuario/cofrinho.git
cd cofrinho
```

### 2. Compilar o Projeto com Maven

Execute o Maven para compilar o projeto e gerar o JAR executável:

```bash
mvn clean package
```

### 3. Executar o JAR

Depois que o JAR for gerado na pasta `target/`, você pode rodá-lo com o comando:

```bash
java -jar cofrinho.jar
```

Isso iniciará o programa e mostrará o menu de operações no terminal.

## Como Usar o Programa

O programa oferece um menu interativo com as seguintes opções:

```
Menu:
1 - Adicionar moeda
2 - Remover moeda
3 - Listar moedas
4 - Calcular valor total convertido para Real
5 - Sair
```

### Exemplo de Uso

1. **Adicionar uma moeda**:
   - O programa solicitará o tipo de moeda (Dólar, Euro, Real) e o valor.
   - Exemplo: Adicionar 10 Dólares.

2. **Remover um valor de uma moeda**:
   - O programa solicitará o tipo de moeda e o valor a ser subtraído da moeda existente.
   - Exemplo: Remover 5 Dólares de uma moeda que tem 10 Dólares.

3. **Listar as moedas**:
   - Exibe todas as moedas presentes no cofrinho, incluindo o tipo e o valor de cada uma.

4. **Calcular o valor total convertido para Real**:
   - O programa exibirá o valor total das moedas convertidas para Reais, considerando as taxas de conversão configuradas.

5. **Sair**:
   - Finaliza o programa.

## Taxas de Conversão Utilizadas

- **Dólar**: 1 Dólar = 5.00 Reais
- **Euro**: 1 Euro = 6.00 Reais
- **Real**: Não há conversão, o valor já está em Reais.

## Licença

MIT.
