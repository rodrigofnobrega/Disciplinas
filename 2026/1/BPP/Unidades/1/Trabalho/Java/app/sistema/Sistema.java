package app.sistema;

import app.noticia.IAnalisadorNoticia;
import app.noticia.enums.ClassificacaoNoticiaEnum;
import app.noticia.model.Noticia;
import app.utils.IScannerHelper;

import java.util.ArrayList;
import java.util.List;

public class Sistema implements ISistema {
    // Lista para guardar as notícias (tirei o static para ficar correto)
    private final List<Noticia> noticias = new ArrayList<>();
    
    // Aqui está a Injeção de Dependência: o Sistema "recebe" o analisador pronto
    private final IAnalisadorNoticia analisadorNoticia;

    private final IScannerHelper scanner;

    // Construtor: avisamos que para o Sistema existir, ele precisa de um analisador
    public Sistema(IAnalisadorNoticia analisadorNoticia, IScannerHelper scanner) {
        this.analisadorNoticia = analisadorNoticia;
        this.scanner = scanner;
    }

    // A "função que faz tudo" agora se chama salvarNoticia
    private void salvarNoticia(String noticia, String classificacao) {
        if (noticia == null || noticia.isBlank()) {
            throw new IllegalArgumentException("Erro ao salvar: O texto da notícia é obrigatório.");
        }
        if (classificacao == null || classificacao.isBlank()) {
            classificacao = ClassificacaoNoticiaEnum.DUVIDOSA.name();
        }

        Noticia novaNoticia = new Noticia(noticia, classificacao);

        noticias.add(novaNoticia);
    }

    public void listarNoticiasCadastradas() {
        if (noticias.isEmpty()) {
            System.out.println("\nNenhuma notícia cadastrada no momento.");
            return;
        }

        for (Noticia noticia : noticias) {
            noticia.exibirNoticia();
        }
    }

    public void cadastrarNoticiaManual() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        String classificacao = scanner.lerEntradaTexto("Informe a classificação: ");

        salvarNoticia(noticia, classificacao);
        System.out.println("Notícia cadastrada com sucesso!");
    }

    public  void cadastrarNoticiaAutomatica() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        String classificacao = analisadorNoticia.analisarNoticia(noticia);

        salvarNoticia(noticia, classificacao);
        System.out.println("Notícia analisada e cadastrada como: " + classificacao);
    }
}
