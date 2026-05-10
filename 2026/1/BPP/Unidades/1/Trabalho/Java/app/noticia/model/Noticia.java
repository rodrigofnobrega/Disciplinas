package app.noticia.model;

public class Noticia {
    private String noticia;
    private String classificacao;

    public Noticia(String noticia, String classificacao) {
        this.noticia = noticia;
        this.classificacao = classificacao;
    }

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