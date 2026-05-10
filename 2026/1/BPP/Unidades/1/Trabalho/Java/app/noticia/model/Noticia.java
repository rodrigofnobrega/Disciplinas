package app.noticia.model;

/**
 * Representa o modelo de entidade de uma Notícia no sistema.
 */
public class Noticia {
    private String noticia;
    private String classificacao;

    /**
     * Construtor para instanciar uma nova Notícia com os seus dados iniciais.
     *
     * @param noticia       O texto contendo o corpo da notícia.
     * @param classificacao A classificação de confiabilidade atribuída à notícia.
     */
    public Noticia(String noticia, String classificacao) {
        this.noticia = noticia;
        this.classificacao = classificacao;
    }

    /**
     * Exibe os detalhes da notícia formatados diretamente no console.
     */
    public void exibirNoticia() {
        System.out.println("-------------------");
        System.out.println("Texto: " + getNoticia());
        System.out.println("Classificacao: " + getClassificacao());
        System.out.println("-------------------");
    }

    public String getNoticia() {
        return this.noticia;
    }
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getClassificacao() {
        return this.classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}