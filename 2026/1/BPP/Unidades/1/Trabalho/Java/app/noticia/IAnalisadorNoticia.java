package app.noticia;

import app.noticia.enums.ClassificacaoNoticiaEnum;

/**
 * Analisa e determina o nível de confiabilidade de uma notícia.
 */
public interface IAnalisadorNoticia {
     /**
      * Analisa o texto de uma notícia e retorna a sua classificação de confiabilidade.
      * <p>
      *
      * @param noticia O texto da notícia a ser analisado.
      * @return O objeto {@link ClassificacaoNoticiaEnum} correspondente ao nível de confiabilidade identificado.
      * @throws RuntimeException Se a string da notícia for nula, vazia ou contiver apenas espaços em branco.
      */
     ClassificacaoNoticiaEnum analisarNoticia(String noticia);
}
