package app.utils;

import java.util.Scanner;

public class ScannerHelper implements IScannerHelper {
    private final Scanner scanner;

    public ScannerHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerEntradaTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public int lerEntradaInteiro(String mensagem) throws NumberFormatException {
        System.out.print(mensagem);
        try {
            // Limpar o caractere ENTER. Se utilizasse o 'scanner.nextInt()' iria sobrar o caractere \n
            // Quebrando o próximo scanner no fluxo de execução
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void fecharScanner() {
        this.scanner.close();
    }
}
