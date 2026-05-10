package app.noticia;

import app.noticia.enums.ClassificacaoNoticiaEnum;

public interface IAnalisadorNoticia {
     ClassificacaoNoticiaEnum analisarNoticia(String noticia);
}
