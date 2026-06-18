package br.com.hamburgueria.atendimento;

public class Cozinha {

    private CentralAtendimento mediator;
    private String pedidoAtual;

    public void setMediator(CentralAtendimento mediator) {
        this.mediator = mediator;
    }

    public void receberPedido(String pedido) {
        this.pedidoAtual = pedido;
        mediator.notificar(this, "pedido_recebido");
    }

    public void prepararPedido() {
        mediator.notificar(this, "pedido_pronto");
    }

    public String getPedidoAtual() {
        return pedidoAtual;
    }
}
