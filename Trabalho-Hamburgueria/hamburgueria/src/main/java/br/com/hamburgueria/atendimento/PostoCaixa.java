package br.com.hamburgueria.atendimento;

public class PostoCaixa {

    private CentralAtendimento mediator;
    private boolean entregaConfirmada = false;

    public void setMediator(CentralAtendimento mediator) {
        this.mediator = mediator;
    }

    public void registrarPedido(String pedido) {
        mediator.notificar(this, "pedido_registrado:" + pedido);
    }

    public void confirmarEntrega() {
        this.entregaConfirmada = true;
    }

    public boolean isEntregaConfirmada() {
        return entregaConfirmada;
    }
}
