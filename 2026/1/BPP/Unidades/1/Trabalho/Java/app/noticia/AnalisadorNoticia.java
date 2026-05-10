package app.noticia;

import app.noticia.enums.ClassificacaoNoticiaEnum;

/**
 * Implementa a interface {@link IAnalisadorNoticia}
 */
public class AnalisadorNoticia implements IAnalisadorNoticia {
    @Override
    public ClassificacaoNoticiaEnum analisarNoticia(String noticia) {
        if (noticia == null || noticia.isBlank()) {
            throw new RuntimeException("Erro ao analisar noticia. A notícia não pode ser vazia/nula");
        }

        int scoreNoticia = calcularScoreNoticia(noticia);

        return classificarNoticia(scoreNoticia);
    }

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
