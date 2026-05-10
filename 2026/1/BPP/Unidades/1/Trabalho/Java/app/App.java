package app;

import app.menu.IMenuSistema;
import app.menu.MenuSistema;
import app.noticia.AnalisadorNoticia;
import app.noticia.IAnalisadorNoticia;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAnalisadorNoticia analisadorNoticia = new AnalisadorNoticia();
        Sistema sistema = new Sistema(analisadorNoticia);

        IMenuSistema menuSistema = new MenuSistema(sistema, scanner);

        menuSistema.menu();
    }
}
