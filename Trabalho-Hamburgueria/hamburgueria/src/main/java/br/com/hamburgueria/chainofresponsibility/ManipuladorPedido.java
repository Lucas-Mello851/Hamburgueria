package br.com.hamburgueria.chainofresponsibility;

public abstract class ManipuladorPedido {

    protected ManipuladorPedido proximo;

    public ManipuladorPedido setProximo(ManipuladorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract void processar(SolicitacaoPedido solicitacao);
}
