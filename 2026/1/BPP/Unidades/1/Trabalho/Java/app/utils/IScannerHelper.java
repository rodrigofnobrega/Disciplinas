package app.utils;

import java.util.Scanner;

/**
 * Contrato para manipulação segura de entradas de dados do usuário.
 * <p>
 * Define os métodos necessários para interagir com o console, garantindo
 * a integridade das leituras de texto e números.
 */
public interface IScannerHelper {
    /**
     * Exibe uma mensagem no console e aguarda o usuário digitar um texto.
     *
     * @param mensagem A mensagem de instrução que será exibida para o usuário (ex: "Digite seu nome: ").
     * @return Uma {@code String} contendo o texto digitado pelo usuário.
     */
    String lerEntradaTexto(String mensagem);
    /**
     * Exibe uma mensagem no console e aguarda o usuário digitar um número inteiro.
     * <p>
     * Este método lê a entrada inteira como texto (limpando o caractere 'ENTER' (\n) do buffer)
     * e depois converte para inteiro. Se o usuário digitar algo que não seja um número válido,
     * o método captura a exceção e retorna -1.
     *
     * @param mensagem A mensagem de instrução que será exibida para o usuário (ex: "Informe a opção desejada: ").
     * @return O número inteiro digitado pelo usuário, ou {@code -1} caso a entrada seja inválida (ex: letras ou símbolos).
     * @throws NumberFormatException Pode ser declarada na assinatura, mas é tratada internamente pelo bloco try-catch.
     */
    int lerEntradaInteiro(String mensagem);
    /**
     * Encerra o fluxo do {@link Scanner} associado a esta classe.
     * <p>
     * Deve ser chamado ao final da execução do programa para liberar os recursos do sistema.
     */
    void fecharScanner();
}
