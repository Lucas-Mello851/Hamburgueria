package br.com.hamburgueria.chainofresponsibility;

public class ValidadorPagamento extends ManipuladorPedido {

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        if (solicitacao.getValor() <= 0) {
            System.out.println("ValidadorPagamento: valor invalido! Pedido rejeitado.");
            return;
        }
        System.out.println("ValidadorPagamento: valor R$" + solicitacao.getValor() + " aprovado.");
        if (proximo != null) {
            proximo.processar(solicitacao);
        }
    }
}
