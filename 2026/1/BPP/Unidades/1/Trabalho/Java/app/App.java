package app;

import app.menu.IMenuSistema;
import app.menu.MenuSistema;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        IMenuSistema menuSistema = new MenuSistema(sistema, scanner);

        menuSistema.menu();
    }
}
