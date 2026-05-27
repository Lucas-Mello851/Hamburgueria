package br.com.hamburgueria.chainofresponsibility;

public class ValidadorEstoque extends ManipuladorPedido {

    @Override
    public void processar(SolicitacaoPedido solicitacao) {
        System.out.println("ValidadorEstoque: verificando estoque para " + solicitacao.getTipo());
        boolean temProximo = proximo != null;
        if (temProximo) {
            proximo.processar(solicitacao);
        }
    }
}
