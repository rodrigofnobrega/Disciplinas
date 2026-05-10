package app.sistema;

import app.noticia.IAnalisadorNoticia;
import app.noticia.enums.ClassificacaoNoticiaEnum;
import app.noticia.model.Noticia;
import app.utils.IScannerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa a interface {@link ISistema}.
 */
public class Sistema implements ISistema {
    private final List<Noticia> noticias = new ArrayList<>();
    private final IAnalisadorNoticia analisadorNoticia;
    private final IScannerHelper scanner;

    /**
     * Construtor da classe Sistema.
     * <p>
     *
     * @param analisadorNoticia A instância da classe {@link IAnalisadorNoticia} por aplicar as regras de classificação automática.
     * @param scanner           A instância da classe {@link IScannerHelper} por ler as entradas do usuário.
     */
    public Sistema(IAnalisadorNoticia analisadorNoticia, IScannerHelper scanner) {
        this.analisadorNoticia = analisadorNoticia;
        this.scanner = scanner;
    }

    @Override
    public void listarNoticiasCadastradas() {
        if (noticias.isEmpty()) {
            System.out.println("\nNenhuma notícia cadastrada no momento.");
            return;
        }

        for (Noticia noticia : noticias) {
            noticia.exibirNoticia();
        }
    }

    @Override
    public void cadastrarNoticiaManual() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        String classificacao = scanner.lerEntradaTexto("Informe a classificação: ");

        salvarNoticia(noticia, classificacao);
        System.out.println("Notícia cadastrada com sucesso!");
    }

    @Override
    public  void cadastrarNoticiaAutomatica() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        ClassificacaoNoticiaEnum classificacao = analisadorNoticia.analisarNoticia(noticia);

        salvarNoticia(noticia, classificacao.name());
        System.out.println("Notícia analisada e cadastrada como: " + classificacao);
    }

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
}
