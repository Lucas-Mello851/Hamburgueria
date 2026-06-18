package br.com.hamburgueria.atendimento;

public class ValidacaoEstoque extends EtapaValidacao {

    private static final java.util.Set<String> TIPOS_DISPONIVEIS =
            new java.util.HashSet<>(java.util.Arrays.asList("Classico", "Smash", "Vegano"));

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        if (!TIPOS_DISPONIVEIS.contains(solicitacao.getTipo())) {
            return;
        }
        if (proximo != null) {
            proximo.processar(solicitacao);
        }
    }
}
