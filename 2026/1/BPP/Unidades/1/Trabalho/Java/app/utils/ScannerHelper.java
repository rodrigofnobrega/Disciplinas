package app.utils;

import java.util.Scanner;

/**
 * Implementação padrão de {@link IScannerHelper} baseada em {@link Scanner}.
 * <p>
 * Fornece métodos seguros para leitura de textos e números via console,
 * evitando problemas comuns de buffer do teclado (como o salto de linhas indesejado).
 */
public class ScannerHelper implements IScannerHelper {
    private final Scanner scanner;

    /**
     * Construtor da classe ScannerHelper.
     *
     * @param scanner A instância de {@link Scanner} que será utilizada para ler as entradas.
     */
    public ScannerHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String lerEntradaTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    @Override
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

    @Override
    public void fecharScanner() {
        this.scanner.close();
    }
}
