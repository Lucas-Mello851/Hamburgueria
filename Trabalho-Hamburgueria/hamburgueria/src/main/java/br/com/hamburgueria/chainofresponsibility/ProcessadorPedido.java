package br.com.hamburgueria.chainofresponsibility;

public class ProcessadorPedido extends ManipuladorPedido {

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        System.out.println("ProcessadorPedido: pedido de " + solicitacao.getTipo() + " enviado para a cozinha!");
        solicitacao.setProcessado(true);
    }
}
