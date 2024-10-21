# Cofrinho Java - Currency Management System 🐖

## Description

This project implements a simple currency management system called **Cofrinho**. The program allows users to add, remove, and list different types of currencies, such as **Dollar**, **Euro**, and **Real**, as well as calculate the total value converted to the **Brazilian Real**.

The project was developed in **Java** using **Maven** as the build tool. It contains basic functionalities for interacting through a console menu, allowing users to manage currencies and check the total balance converted to Real.

## Features

- Add different types of currencies (Dollar, Euro, and Real).
- Remove a specific value from an existing currency.
- List all the currencies stored in the piggy bank.
- Calculate the total value of all currencies converted to Brazilian Real.
- Exit the program.

## Project Structure

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

- **`Cofrinho.java`**: Class that manages the operations of adding, removing, and listing currencies.
- **`Moeda.java`**: Abstract class that defines the common behavior for all currencies.
- **`Dolar.java`**, **`Euro.java`**, **`Real.java`**: Subclasses of `Moeda` that implement the specific methods for each currency.
- **`pom.xml`**: Maven configuration file.

## Requirements

- **Java 11** or higher (preferably Java 17).
- **Maven** for building and dependency management.

## How to Run the Project

### 1. Clone the Repository

Clone the project repository to your local environment:

```bash
git clone https://github.com/your-username/cofrinho.git
cd cofrinho
```

### 2. Compile the Project with Maven

Run Maven to compile the project and generate the executable JAR:

```bash
mvn clean package
```

### 3. Run the JAR

Once the JAR is generated in the `target/` folder, you can run it with the command:

```bash
java -jar cofrinho.jar
```

This will start the program and display the operations menu in the terminal.

## How to Use the Program

The program offers an interactive menu with the following options:

```
Menu:
1 - Add currency
2 - Remove currency
3 - List currencies
4 - Calculate total value converted to Real
5 - Exit
```

### Usage Example

1. **Add a currency**:
   - The program will ask for the type of currency (Dollar, Euro, Real) and the value.
   - Example: Add 10 Dollars.

2. **Remove a value from a currency**:
   - The program will ask for the type of currency and the amount to be subtracted from the existing currency.
   - Example: Remove 5 Dollars from a currency that has 10 Dollars.

3. **List the currencies**:
   - Displays all currencies stored in the piggy bank, including the type and value of each.

4. **Calculate the total value converted to Real**:
   - The program will display the total value of the currencies converted to Brazilian Real, based on the configured exchange rates.

5. **Exit**:
   - Exits the program.

## Exchange Rates Used

- **Dollar**: 1 Dollar = 5.00 Reais
- **Euro**: 1 Euro = 6.00 Reais
- **Real**: No conversion needed, as the value is already in Reais.

## License

MIT.
