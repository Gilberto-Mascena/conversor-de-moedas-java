package br.com.mascenadev.conversor.entities;

import java.util.Scanner;

public class Instatiation {


    private final ConsumeApi consumeApi = new ConsumeApi();
    private final Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        var option = -1;
        while (option != 0) {

            var menu = """
                    ************************************************
                     Bem vindo ao conversor de moedas!
                        Escolha uma opção:
                                        
                     1 - Real ==> Dólar
                     2 - Dólar ==> Real
                     3 - Euro ==> Real
                     4 - Real ==> Euro
                     5 - Euro ==> Dólar
                     6 - Dólar ==> Euro 
                                                                               
                     0 - Sair
                    ************************************************                    
                    """;
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    convert(consumeApi.getData("BRL", "USD"));
                    break;
                case 2:
                    convert(consumeApi.getData("USD", "BRL"));
                    break;
                case 3:
                    convert(consumeApi.getData("EUR", "BRL"));
                    break;
                case 4:
                    convert(consumeApi.getData("BRL", "EUR"));
                    break;
                case 5:
                    convert(consumeApi.getData("EUR", "USD"));
                    break;
                case 6:
                    convert(consumeApi.getData("USD", "EUR"));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void convert(double value) {

        try {
            System.out.println("Digite o valor a ser convertido: ");
            double amount = Double.parseDouble(sc.nextLine());
            double result = amount * value;
            System.out.println("Valor convertido: " + String.format("%.2f", result) + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível realizar a conversão.");
        }
    }
}