package app.menu;

import app.sistema.ISistema;
import app.utils.IScannerHelper;
import app.sistema.Sistema;

import java.util.Scanner;

/**
 * Implementa a interface {@link IMenuSistema}.
 */
public class MenuSistema implements IMenuSistema {
    private final ISistema sistema;
    private final IScannerHelper scanner;

    /**
     * Construtor da classe MenuSistema.
     *
     * @param sistema A instância da classe {@link ISistema} que contém as regras de negócio e dados das notícias.
     * @param scanner A instância de {@link IScannerHelper} utilizada para ler as entradas do teclado.
     */
    public MenuSistema(ISistema sistema, IScannerHelper scanner) {
        this.sistema = sistema;
        this.scanner = scanner;
    }

    @Override
    public void menu() throws NumberFormatException {
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuInicial();

            int opcao = scanner.lerEntradaInteiro("Informe a opção desejada: ");

            continuarExecutando = processarOpcaoMenu(opcao);
        }
    }

    private void exibirMenuInicial() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    private boolean processarOpcaoMenu(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    this.sistema.cadastrarNoticiaManual();
                    return true;
                case 2:
                    sistema.cadastrarNoticiaAutomatica();
                    return true;
                case 3:
                    sistema.listarNoticiasCadastradas();
                    return true;
                case 4:
                    System.out.println("Saindo...");
                    scanner.fecharScanner();
                    return false;
                default:
                    System.out.println("A opção informada é inválida. Os valores válidos são de 1 a 4");
                    return true;
            }
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return true;
    }
}
