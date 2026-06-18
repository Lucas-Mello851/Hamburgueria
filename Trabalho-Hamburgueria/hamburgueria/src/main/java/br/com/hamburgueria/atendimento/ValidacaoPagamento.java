package br.com.hamburgueria.atendimento;

public class ValidacaoPagamento extends EtapaValidacao {

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        if (solicitacao.getValor() <= 0) {
            return;
        }
        if (proximo != null) {
            proximo.processar(solicitacao);
        }
    }
}
