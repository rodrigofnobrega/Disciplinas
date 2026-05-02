package app.noticia;

import app.noticia.enums.ClassificacaoNoticiaEnum;

public class AnalisadorNoticia implements IAnalisadorNoticia {
    /**
     * Analisa o texto de uma notícia e retorna a sua classificação de confiabilidade em formato de texto.
     * <p>
     *
     * @param noticia O texto da notícia a ser analisado.
     * @return O nome da constante do enum (ex: "CONFIAVEL", "DUVIDOSA" ou "FALSA") em formato String.
     * @throws RuntimeException Se a string da notícia for nula, vazia ou contiver apenas espaços em branco.
     */
    public String analisarNoticia(String noticia) {
        if (noticia == null || noticia.isBlank()) {
            throw new RuntimeException("Erro ao analisar noticia. A notícia não pode ser vazia/nula");
        }

        int scoreNoticia = calcularScoreNoticia(noticia);

        return classificarNoticia(scoreNoticia).name();
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
    private int calcularScoreNoticia(String noticia) {
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
     * Converte a pontuação numérica de uma notícia em uma categoria do {@link ClassificacaoNoticiaEnum}.
     *
     * @param score A pontuação calculada da notícia. Não pode ser um valor negativo.
     * @return {@code CONFIAVEL} para score 0, {@code DUVIDOSA} para score 1, e {@code FALSA} para score 2 ou maior.
     * @throws RuntimeException Se o score fornecido for negativo.
     */
    private ClassificacaoNoticiaEnum classificarNoticia(int score) {
        if (score < 0) {
            throw new RuntimeException("O score não pode ser negativo");
        }

        if (score == 0) {
            return ClassificacaoNoticiaEnum.CONFIAVEL;
        } else if (score == 1) {
            return  ClassificacaoNoticiaEnum.DUVIDOSA;
        } else {
            return  ClassificacaoNoticiaEnum.FALSA;
        }
    }
}
