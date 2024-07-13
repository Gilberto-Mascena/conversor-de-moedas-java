package br.com.mascenadev.conversor.entities;

import br.com.mascenadev.conversor.service.ConsumeApi;

import java.util.Scanner;

public class Instatiation {


    private final ConsumeApi consumeApi = new ConsumeApi();
    private final Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        var option = -1;
        while (option != 0) {

            var menu = """
                    \n
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
                    convert(" USD", consumeApi.getData("BRL", "USD"));
                    break;
                case 2:
                    convert(" BRL", consumeApi.getData("USD", "BRL"));
                    break;
                case 3:
                    convert(" BRL", consumeApi.getData("EUR", "BRL"));
                    break;
                case 4:
                    convert(" EUR", consumeApi.getData("BRL", "EUR"));
                    break;
                case 5:
                    convert(" USD", consumeApi.getData("EUR", "USD"));
                    break;
                case 6:
                    convert(" EUR", consumeApi.getData("USD", "EUR"));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite uma opção válida.\n");
            }
        }
    }

    Double amount;

    private void convert(String coin, Double value) {

        System.out.println("Digite o valor a ser convertido: ");
        amount = Double.parseDouble(sc.nextLine());

        if (amount > 0) {
            double result = amount * value;
            System.out.println("Valor convertido => " + String.format("%.2f", result) + coin + "\n");
        }

        else  {
            System.out.println("Digite um valor maior ou igual a um!\n");
        }
    }
}