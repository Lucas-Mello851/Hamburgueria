package br.com.hamburgueria.mediator;

public class Caixa {

    private RestauranteMediator mediator;

    public void setMediator(RestauranteMediator mediator) {
        this.mediator = mediator;
    }

    public void registrarPedido(String pedido) {
        System.out.println("Caixa: registrando pedido - " + pedido);
        mediator.notificar(this, "pedido_registrado:" + pedido);
    }

    public void confirmarEntrega() {
        System.out.println("Caixa: pedido entregue ao cliente.");
    }
}
