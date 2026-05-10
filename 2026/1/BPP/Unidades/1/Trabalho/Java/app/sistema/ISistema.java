package app.sistema;

import app.noticia.IAnalisadorNoticia;

/**
 *  Gerencia as operações principais do sistema de notícias.
 */
public interface ISistema {
    /**
     * Exibe no console todas as notícias que estão cadastradas no sistema.
     * <p>
     * Caso a lista de notícias esteja vazia, exibe uma mensagem informando.
     */
    void listarNoticiasCadastradas();
    /**
     * Inicia o fluxo de cadastro manual de uma notícia.
     * <p>
     * Solicita ao usuário, através do console, o texto da notícia e a sua classificação.
     * Em seguida, envia os dados informados para serem validados e salvos.
     */
    void cadastrarNoticiaManual();
    /**
     * Inicia o fluxo de cadastro automático de uma notícia.
     * <p>
     * Solicita ao usuário apenas o texto da notícia e delega a responsabilidade de
     * definir a confiabilidade ao {@link IAnalisadorNoticia} injetado no sistema.
     * Após a análise, a notícia e o resultado gerado são salvos.
     */
    void cadastrarNoticiaAutomatica();
}
