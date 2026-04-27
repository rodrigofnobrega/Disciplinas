import java.util.ArrayList;
import java.util.Scanner;

class D {
    String t;
    String c;
}

/**
 * Enum que representa os níveis de confiabilidade de uma notícia.
 */
enum ClassificaoNoticiaEnum {
    CONFIAVEL,
    DUVIDOSA,
    FALSA
}

public class Sistema {

    static ArrayList<D> data = new ArrayList<>();

    // função que faz tudo
    public static void f(String a, String b) {
        // adiciona coisa
        if (a != null && !a.equals("")) {
            D d = new D();
            d.t = a;

            if (b == null || b.equals("")) {
                d.c = "duvidosa";
            } else {
                d.c = b;
            }

            data.add(d);
        } else {
            System.out.println("erro");
        }
    }

    public static void func2() {
        // lista tudo
        for (int i = 0; i < data.size(); i++) {
            System.out.println("Texto: " + data.get(i).t);
            System.out.println("Classificacao: " + data.get(i).c);
            System.out.println("-------------------");
        }
    }

    /**
     * Calcula a pontuação (score) de falsidade de uma notícia com base em regras pré-determinadas.
     * <p>
     * A pontuação é incrementada em 1 para cada uma das seguintes condições atendidas:
     * <ul>
     * <li>O texto não contém a palavra "FONTE".</li>
     * <li>O texto contém exclamações repetidas ("!!!").</li>
     * <li>O texto contém a palavra "URGENTE".</li>
     * <li>O texto possui menos de 10 caracteres.</li>
     * </ul>
     *
     * @param noticia O texto da notícia a ser avaliado.
     * @return O valor inteiro representando o score da notícia (quanto maior, menos confiável).
     * @throws RuntimeException Se a string da notícia for nula, vazia ou contiver apenas espaços em branco.
     */
    public static int calcularScoreNoticia(String noticia) {
        if (noticia == null || noticia.isBlank()) {
            throw new RuntimeException("Erro ao calcular score, a notícia não pode ser vazia/nula");
        }

        int score = 0;

        if (!noticia.contains("FONTE")) {
            score++;
        }
        if (noticia.contains("!!!")) {
            score++;
        }
        if (noticia.contains("URGENTE")) {
            score++;
        }
        if (noticia.length() < 10) {
            score++;
        }

        return score;
    }

    /**
     * Converte a pontuação numérica de uma notícia em uma categoria do {@link ClassificaoNoticiaEnum}.
     *
     * @param score A pontuação calculada da notícia. Não pode ser um valor negativo.
     * @return {@code CONFIAVEL} para score 0, {@code DUVIDOSA} para score 1, e {@code FALSA} para score 2 ou maior.
     * @throws RuntimeException Se o score fornecido for negativo.
     */
    public static ClassificaoNoticiaEnum classificarNoticia(int score) {
        if (score < 0) {
            throw new RuntimeException("O score não pode ser negativo");
        }

        if (score == 0) {
            return ClassificaoNoticiaEnum.CONFIAVEL;
        } else if (score == 1) {
            return  ClassificaoNoticiaEnum.DUVIDOSA;
        } else {
            return  ClassificaoNoticiaEnum.FALSA;
        }
    }

    /**
     * Analisa o texto de uma notícia e retorna a sua classificação de confiabilidade em formato de texto.
     * <p>
     *
     * @param noticia O texto da notícia a ser analisado.
     * @return O nome da constante do enum (ex: "CONFIAVEL", "DUVIDOSA" ou "FALSA") em formato String.
     * @throws RuntimeException Se a string da notícia for nula, vazia ou contiver apenas espaços em branco.
     */
    public static String analisarNoticia(String noticia) {
        if (noticia == null || noticia.isBlank()) {
            throw new RuntimeException("Erro ao analisar noticia. A notícia não pode ser vazia/nula");
        }

        int scoreNoticia = calcularScoreNoticia(noticia);

        return classificarNoticia(scoreNoticia).name();
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

        String c = analisarNoticia(t);
        f(t, c);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - adicionar manual");
            System.out.println("2 - adicionar automatico");
            System.out.println("3 - listar");
            System.out.println("4 - sair");

            String op = sc.nextLine();

            if (op.equals("1")) {
                addManual(sc);
            } else if (op.equals("2")) {
                addAuto(sc);
            } else if (op.equals("3")) {
                func2();
            } else if (op.equals("4")) {
                break;
            } else {
                System.out.println("errado");
            }
        }

        sc.close();
    }

    // inicia programa
    public static void main(String[] args) {
        menu();
    }
}
