package com.currencyconverter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Conversor de Moedas!");

        while (true) {
            System.out.println("\nEscolha uma opção de conversão:");
            System.out.println("1. USD para EUR");
            System.out.println("2. EUR para USD");
            System.out.println("3. BRL para USD");
            System.out.println("4. USD para BRL");
            System.out.println("5. JPY para BRL");
            System.out.println("6. BRL para JPY");
            System.out.println("7. Sair");
            System.out.print("Opção: ");

            int option = scanner.nextInt();
            if (option == 7) {
                System.out.println("Obrigado por usar o Conversor de Moedas. Até logo!");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            String fromCurrency = "";
            String toCurrency = "";

            switch (option) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "EUR";
                    break;
                case 2:
                    fromCurrency = "EUR";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    break;
                case 4:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case 5:
                    fromCurrency = "JPY";
                    toCurrency = "BRL";
                    break;
                case 6:
                    fromCurrency = "BRL";
                    toCurrency = "JPY";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            try {
                double rate = getExchangeRate(fromCurrency, toCurrency);
                double convertedAmount = amount * rate;
                System.out.printf("%.2f %s equivale a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (IOException | InterruptedException e) {
                System.err.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + fromCurrency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = jsonResponse.getAsJsonObject("rates");
            return rates.get(toCurrency).getAsDouble();
        } else {
            throw new IOException("Falha ao obter dados da API. Código de status: " + response.statusCode());
        }
    }
}


