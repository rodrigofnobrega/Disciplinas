package app;

import app.noticia.AnalisadorNoticia;
import app.noticia.IAnalisadorNoticia;
import app.noticia.model.Noticia;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    static ArrayList<Noticia> data = new ArrayList<>();

    // função que faz tudo
    public static void f(String a, String b) {
        // adiciona coisa
        if (a != null && !a.equals("")) {
            Noticia noticiaClassificada = new Noticia();
            noticiaClassificada.setNoticia(a);

            if (b == null || b.equals("")) {
                noticiaClassificada.setClassificacao("duvidosa");
            } else {
                noticiaClassificada.setClassificacao(b);
            }

            data.add(noticiaClassificada);
        } else {
            System.out.println("erro");
        }
    }

    public static void listarNoticiasCadastradas() {
        for (Noticia noticia : data) {
            noticia.exibirNoticia();
        }
    }

    public static void addManual(Scanner sc) {
        System.out.print("Digite o texto: ");
        String t = sc.nextLine();

        System.out.print("Digite classificacao: ");
        String c = sc.nextLine();

        if (c.equals("")) {
            f(t, null);
        } else {
            f(t, c);
        }
    }

    public static void addAuto(Scanner sc) {
        System.out.print("Digite o texto: ");
        String t = sc.nextLine();

        IAnalisadorNoticia analisadorNoticia = new AnalisadorNoticia();
        String c = analisadorNoticia.analisarNoticia(t);

        f(t, c);
    }
}
