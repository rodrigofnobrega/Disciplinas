package app.menu;

import app.utils.ScannerHelper;
import app.Sistema;

import java.util.Scanner;

public class MenuSistema implements IMenuSistema {
    private final Sistema sistema;
    private final Scanner scanner;

    public MenuSistema(Sistema sistema, Scanner scanner) {
        this.sistema = sistema;
        this.scanner = scanner;
    }

    public void menu() throws NumberFormatException {
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuInicial();

            int opcao = ScannerHelper.lerEntradaInteiro("Informe a opção desejada: ", scanner);

            continuarExecutando = processarOpcaoMenu(opcao, scanner);
        }

        scanner.close();
    }

    private void exibirMenuInicial() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    private boolean processarOpcaoMenu(int opcao, Scanner scanner) {
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
