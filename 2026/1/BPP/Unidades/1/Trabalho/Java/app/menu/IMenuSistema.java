package app.menu;

/**
 * Gerencia o  menu interativo do sistema.
 */
public interface IMenuSistema {
    /**
     * Inicia o laço de execução principal do menu.
     * <p>
     * O método exibe o menu inicial, captura a opção do usuário e redireciona para a funcionalidade escolhida.
     * O laço é mantido até que a opção de saída seja selecionada.
     *
     * @throws NumberFormatException Se houver uma falha ao converter a entrada do usuário para número.
     */
    void menu();
}
