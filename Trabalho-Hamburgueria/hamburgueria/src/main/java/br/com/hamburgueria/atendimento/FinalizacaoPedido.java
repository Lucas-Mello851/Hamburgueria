package br.com.hamburgueria.atendimento;

public class FinalizacaoPedido extends EtapaValidacao {

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        solicitacao.setProcessado(true);
    }
}
