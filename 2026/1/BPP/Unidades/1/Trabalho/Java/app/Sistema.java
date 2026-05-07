package app;

import app.noticia.IAnalisadorNoticia;
import app.noticia.model.Noticia;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    // Lista para guardar as notícias (tirei o static para ficar correto)
    private final List<Noticia> noticias = new ArrayList<>();
    
    // Aqui está a Injeção de Dependência: o Sistema "recebe" o analisador pronto
    private final IAnalisadorNoticia analisador;

    // Construtor: avisamos que para o Sistema existir, ele precisa de um analisador
    public Sistema(IAnalisadorNoticia analisador) {
        this.analisador = analisador;
    }

    // A "função que faz tudo" agora se chama salvarNoticia
    public void salvarNoticia(String texto, String classificacao) {
        if (texto != null && !texto.isBlank()) {
            Noticia novaNoticia = new Noticia();
            novaNoticia.setNoticia(texto);

            // Se não informarem a classificação, vira "duvidosa" por padrão
            if (classificacao == null || classificacao.isBlank()) {
                novaNoticia.setClassificacao("duvidosa");
            } else {
                novaNoticia.setClassificacao(classificacao);
            }

            noticias.add(novaNoticia);
        }
    }

    public void listarNoticias() {
        for (Noticia n : noticias) {
            n.exibirNoticia();
        }
    }

    // Agora o Sistema pede para o analisador fazer o trabalho dele
    public String analisarTexto(String texto) {
        return this.analisador.analisarNoticia(texto);
    }
}
