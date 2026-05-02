package app.menu;

import app.ScannerHelper;
import app.Sistema;

import java.util.Scanner;

public class MenuSistema implements IMenuSistema {

    public void menu() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            MenuSistema.exibirMenuInicial();

            int opcao = ScannerHelper.lerEntradaInteiro("Informe a opção desejada: ", scanner);

            continuarExecutando = MenuSistema.processarOpcaoMenu(opcao, scanner);
        }

        scanner.close();
    }

    private static void exibirMenuInicial() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    private static boolean processarOpcaoMenu(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                Sistema.addManual(scanner);
                return true;
            case 2:
                Sistema.addAuto(scanner);
                return true;
            case 3:
                Sistema.listarNoticiasCadastradas();
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
