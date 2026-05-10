package app;

import app.menu.IMenuSistema;
import app.menu.MenuSistema;
import app.noticia.AnalisadorNoticia;
import app.noticia.IAnalisadorNoticia;
import app.sistema.ISistema;
import app.sistema.Sistema;
import app.utils.IScannerHelper;
import app.utils.ScannerHelper;

import java.util.Scanner;

/**
 * Classe principal responsável por inicializar a aplicação.
 */
public class App {
    /**
     * Método principal que dá início à execução do programa.
     *
     * @param args Argumentos de linha de comando passados durante a inicialização (não utilizados nesta aplicação).
     */
    public static void main(String[] args) {
        IAnalisadorNoticia analisadorNoticia = new AnalisadorNoticia();
        IScannerHelper scanner = new ScannerHelper(new Scanner(System.in));
        ISistema sistema = new Sistema(analisadorNoticia, scanner);

        IMenuSistema menuSistema = new MenuSistema(sistema, scanner);

        menuSistema.menu();
    }
}
