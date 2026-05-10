package app.sistema;

import app.noticia.IAnalisadorNoticia;
import app.noticia.enums.ClassificacaoNoticiaEnum;
import app.noticia.model.Noticia;
import app.utils.IScannerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar as operações principais do sistema de notícias.
 * <p>
 * Implementa a interface {@link ISistema} e atua como o ponto principal da aplicação,
 * armazenando as notícias cadastradas e coordena as ações de entrada de dados
 * e classificação das notícias.
 */
public class Sistema implements ISistema {
    private final List<Noticia> noticias = new ArrayList<>();
    private final IAnalisadorNoticia analisadorNoticia;
    private final IScannerHelper scanner;

    /**
     * Construtor da classe Sistema.
     * <p>
     * Recebe as dependências necessárias para o funcionamento da classe.
     *
     * @param analisadorNoticia A instância responsável por aplicar as regras de classificação automática.
     * @param scanner           A instância utilitária responsável por ler as entradas do usuário.
     */
    public Sistema(IAnalisadorNoticia analisadorNoticia, IScannerHelper scanner) {
        this.analisadorNoticia = analisadorNoticia;
        this.scanner = scanner;
    }

    /**
     * Valida, padroniza e salva uma nova notícia na lista do sistema.
     * <p>
     * Se a classificação informada for nula ou vazia, o sistema atribui automaticamente
     * a classificação padrão {@code DUVIDOSA}.
     *
     * @param noticia       O texto contendo a notícia. Não pode ser nulo ou vazio.
     * @param classificacao A classificação atribuída à notícia (ex: CONFIAVEL, DUVIDOSA, FALSA).
     * @throws IllegalArgumentException Se o texto da notícia for nulo, vazio ou contiver apenas espaços em branco.
     */
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

    /**
     * Exibe no console todas as notícias que estão cadastradas no sistema.
     * <p>
     * Caso a lista de notícias esteja vazia, exibe uma mensagem informando.
     */
    public void listarNoticiasCadastradas() {
        if (noticias.isEmpty()) {
            System.out.println("\nNenhuma notícia cadastrada no momento.");
            return;
        }

        for (Noticia noticia : noticias) {
            noticia.exibirNoticia();
        }
    }

    /**
     * Inicia o fluxo de cadastro manual de uma notícia.
     * <p>
     * Solicita ao usuário, através do console, o texto da notícia e a sua classificação.
     * Em seguida, envia os dados informados para serem validados e salvos.
     */
    public void cadastrarNoticiaManual() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        String classificacao = scanner.lerEntradaTexto("Informe a classificação: ");

        salvarNoticia(noticia, classificacao);
        System.out.println("Notícia cadastrada com sucesso!");
    }

    /**
     * Inicia o fluxo de cadastro automático de uma notícia.
     * <p>
     * Solicita ao usuário apenas o texto da notícia e delega a responsabilidade de
     * definir a confiabilidade ao {@link IAnalisadorNoticia} injetado no sistema.
     * Após a análise, a notícia e o resultado gerado são salvos.
     */
    public  void cadastrarNoticiaAutomatica() {
        String noticia = scanner.lerEntradaTexto("Informe a notícia: ");
        ClassificacaoNoticiaEnum classificacao = analisadorNoticia.analisarNoticia(noticia);

        salvarNoticia(noticia, classificacao.name());
        System.out.println("Notícia analisada e cadastrada como: " + classificacao);
    }
}
