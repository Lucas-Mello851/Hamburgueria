package br.com.hamburgueria.mediator;

public class Cozinha {

    private RestauranteMediator mediator;
    private String pedidoAtual;

    public void setMediator(RestauranteMediator mediator) {
        this.mediator = mediator;
    }

    public void receberPedido(String pedido) {
        this.pedidoAtual = pedido;
        System.out.println("Cozinha: recebeu pedido - " + pedido);
        mediator.notificar(this, "pedido_recebido");
    }

    public void prepararPedido() {
        System.out.println("Cozinha: preparando - " + pedidoAtual);
        mediator.notificar(this, "pedido_pronto");
    }

    public String getPedidoAtual() {
        return pedidoAtual;
    }
}
