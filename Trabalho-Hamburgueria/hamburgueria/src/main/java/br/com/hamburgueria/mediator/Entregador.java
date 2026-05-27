package br.com.hamburgueria.mediator;

public class Entregador {

    private RestauranteMediator mediator;

    public void setMediator(RestauranteMediator mediator) {
        this.mediator = mediator;
    }

    public void buscarPedido(String pedido) {
        System.out.println("Entregador: buscando pedido - " + pedido);
        mediator.notificar(this, "pedido_retirado");
    }
}
