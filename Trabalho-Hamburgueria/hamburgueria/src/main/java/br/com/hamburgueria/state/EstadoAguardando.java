package br.com.hamburgueria.state;

public class EstadoAguardando implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) {
        System.out.println("Pedido confirmado!");
        contexto.setEstado(new EstadoEmPreparo());
    }

    @Override
    public void preparar(ContextoPedido contexto) {
        System.out.println("Pedido ainda nao foi confirmado.");
    }

    @Override
    public void entregar(ContextoPedido contexto) {
        System.out.println("Pedido ainda nao foi confirmado.");
    }

    @Override
    public void cancelar(ContextoPedido contexto) {
        System.out.println("Pedido cancelado antes de iniciar.");
        contexto.setEstado(new EstadoCancelado());
    }

    @Override
    public String getStatus() { return "Aguardando confirmacao"; }
}
