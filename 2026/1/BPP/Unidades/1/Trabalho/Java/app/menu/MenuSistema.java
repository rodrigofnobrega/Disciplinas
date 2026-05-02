package app.menu;

import app.utils.ScannerHelper;
import app.Sistema;

import java.util.Scanner;

/**
 * Classe responsável por gerenciar a interface de menu interativo do sistema.
 * <p>
 * Implementa a interface {@link IMenuSistema} e utiliza a injeção de dependência
 * para isolar a responsabilidade de interação com o usuário das lógicas de negócio.
 */
public class MenuSistema implements IMenuSistema {
    private final Sistema sistema;
    private final Scanner scanner;

    /**
     * Construtor da classe MenuSistema.
     *
     * @param sistema A instância da classe {@link Sistema} que contém as regras de negócio e dados das notícias.
     * @param scanner A instância de {@link Scanner} utilizada para ler as entradas do teclado.
     */
    public MenuSistema(Sistema sistema, Scanner scanner) {
        this.sistema = sistema;
        this.scanner = scanner;
    }

    /**
     * Inicia o laço de execução principal do menu.
     * <p>
     * O método exibe o menu inicial, captura a opção do usuário e redireciona para a funcionalidade escolhida.
     * O laço é mantido até que a opção de saída seja selecionada.
     *
     * @throws NumberFormatException Se houver uma falha ao converter a entrada do usuário para número.
     */
    public void menu() throws NumberFormatException {
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuInicial();

            int opcao = ScannerHelper.lerEntradaInteiro("Informe a opção desejada: ", scanner);

            continuarExecutando = processarOpcaoMenu(opcao);
        }

        scanner.close();
    }

    /**
     * Exibe as opções de funcionalidades do menu no console.
     */
    private void exibirMenuInicial() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    /**
     * Processa a opção escolhida pelo usuário e aciona a funcionalidade correspondente no sistema.
     *
     * @param opcao   O número inteiro digitado pelo usuário correspondente a uma funcionalidade.
     * @return {@code true} se o menu deve continuar sendo exibido, ou {@code false} caso a opção de sair (4) seja escolhida.
     */
    private boolean processarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                this.sistema.addManual(scanner);
                return true;
            case 2:
                sistema.addAuto(scanner);
                return true;
            case 3:
                sistema.listarNoticiasCadastradas();
                return true;
            case 4:
                System.out.println("Saindo...");
                scanner.close();
                return false;
            default:
                System.out.println("A opção informada é inválida. Os valores válidos são de 1 a 4");
                return true;
        }
    }
}
