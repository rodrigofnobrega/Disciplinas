package app.utils;

import java.util.Scanner;

public class ScannerHelper {
    public static String lerEntradaTexto(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int lerEntradaInteiro(String mensagem, Scanner scanner) throws NumberFormatException {
        System.out.print(mensagem);
        try {
            // Limpar o caractere ENTER. Se utilizasse o 'scanner.nextInt()' iria sobrar o caractere \n
            // Quebrando o próximo scanner no fluxo de execução
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
