package br.com.hamburgueria.atendimento;

public class Entregador {

    private CentralAtendimento mediator;

    public void setMediator(CentralAtendimento mediator) {
        this.mediator = mediator;
    }

    public void buscarPedido(String pedido) {
        mediator.notificar(this, "pedido_retirado");
    }
}
