# Conversor de Moedas

Este é um projeto simples de Conversor de Moedas desenvolvido em Java, que interage com o usuário via console e obtém taxas de câmbio em tempo real de uma API externa.

## Funcionalidades

- Conversão de moedas entre USD, EUR, BRL e JPY.
- Obtenção de taxas de câmbio dinamicamente através da API [ExchangeRate-API](https://www.exchangerate-api.com/).
- Menu interativo com opções de conversão.

## Pré-requisitos

- Java Development Kit (JDK) 11 ou superior.
- Apache Maven.

## Como Compilar e Executar

Siga os passos abaixo para compilar e executar o projeto:

1.  **Navegue até o diretório do projeto:**

    ```bash
    cd currency_converter
    ```

2.  **Compile o projeto usando Maven:**

    ```bash
    mvn clean install
    ```

    Este comando irá baixar as dependências necessárias (Gson) e compilar o projeto, gerando um arquivo JAR executável com todas as dependências em `target/currency-converter-1.0-SNAPSHOT-jar-with-dependencies.jar`.

3.  **Execute a aplicação:**

    ```bash
    java -jar target/currency-converter-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```

    A aplicação será iniciada no console, apresentando o menu de opções de conversão.

## Exemplo de Uso

```
Bem-vindo ao Conversor de Moedas!

Escolha uma opção de conversão:
1. USD para EUR
2. EUR para USD
3. BRL para USD
4. USD para BRL
5. JPY para BRL
6. BRL para JPY
7. Sair
Opção: 1
Digite o valor a ser convertido: 100
100.00 USD equivale a 85.66 EUR

Escolha uma opção de conversão:
1. USD para EUR
2. EUR para USD
3. BRL para USD
4. USD para BRL
5. JPY para BRL
6. BRL para JPY
7. Sair
Opção: 7
Obrigado por usar o Conversor de Moedas. Até logo!
```

## Estrutura do Projeto

```
currency_converter/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── currencyconverter/
│                   └── CurrencyConverter.java
└── README.md
```

## API Utilizada

As taxas de câmbio são obtidas da [ExchangeRate-API](https://www.exchangerate-api.com/). A versão gratuita (Open Access) é utilizada, que não requer chave de API e é atualizada uma vez por dia. Para mais detalhes sobre a API, consulte a [documentação](https://www.exchangerate-api.com/docs/free).


