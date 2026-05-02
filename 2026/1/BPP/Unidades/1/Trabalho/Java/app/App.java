package app;

import app.menu.IMenuSistema;
import app.menu.MenuSistema;

public class App {
    public static void main(String[] args) {
        IMenuSistema menuSistema = new MenuSistema();
        menuSistema.menu();
    }
}
