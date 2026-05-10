package app.utils;

import java.util.Scanner;

/**
 * Classe utilitária para manipulação de entradas de dados via console.
 * <p>
 * Implementa a interface {@link IScannerHelper} e encapsula um objeto {@link Scanner},
 * fornecendo métodos seguros para leitura de textos e números, evitando problemas comuns
 * de buffer do teclado (como o salto de linhas indesejado).
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

    /**
     * Exibe uma mensagem no console e aguarda o usuário digitar um texto.
     *
     * @param mensagem A mensagem de instrução que será exibida para o usuário (ex: "Digite seu nome: ").
     * @return Uma {@code String} contendo o texto digitado pelo usuário.
     */
    public String lerEntradaTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * Exibe uma mensagem no console e aguarda o usuário digitar um número inteiro.
     * <p>
     * Este método lê a entrada inteira como texto (limpando o caractere 'ENTER' do buffer)
     * e depois converte para inteiro. Se o usuário digitar algo que não seja um número válido,
     * o método captura a exceção e retorna -1.
     *
     * @param mensagem A mensagem de instrução que será exibida para o usuário (ex: "Informe a opção desejada: ").
     * @return O número inteiro digitado pelo usuário, ou {@code -1} caso a entrada seja inválida (ex: letras ou símbolos).
     * @throws NumberFormatException Pode ser declarada na assinatura, mas é tratada internamente pelo bloco try-catch.
     */
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

    /**
     * Encerra o fluxo do {@link Scanner} associado a esta classe.
     * <p>
     * Deve ser chamado ao final da execução do programa para liberar os recursos do sistema.
     */
    public void fecharScanner() {
        this.scanner.close();
    }
}
