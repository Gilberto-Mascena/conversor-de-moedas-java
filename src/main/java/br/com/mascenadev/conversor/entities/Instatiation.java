
package br.com.mascenadev.conversor.entities;

import br.com.mascenadev.conversor.service.ConsumeApi;

import java.util.InputMismatchException;
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
                     Welcome to the currency converter!
                     Choose an option:
                   \s
                    1 - Real ==> Dollar
                    2 - Dollar ==> Real
                    3 - Euro ==> Real
                    4 - Real ==> Euro
                    5 - Euro ==> Dollar
                    6 - Dollar ==> Euro
                   \s
                    0 - Exit
                    ************************************************\s
                   \s""";

            System.out.println(menu);
            try {

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
                        System.out.println("Leaving...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option! Only numbers are allowed.\n");
                sc.nextLine();
            }
        }
    }

    double amount;

    private void convert(String coin, Double value) {
        try {
            System.out.print("Enter the amount to be converted:");
            amount = Double.parseDouble(sc.nextLine());

            if (amount > 0) {
                double result = amount * value;
                System.out.println();
                System.out.println("Converted value =>" + String.format("%.2f", result) + coin + "\n");
            } else if (amount <= 0) {
                System.out.println();
                System.out.println("Enter a value greater than or equal to 1!\n");
            }
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid value! Only numbers are allowed.\n");
        }
    }
}