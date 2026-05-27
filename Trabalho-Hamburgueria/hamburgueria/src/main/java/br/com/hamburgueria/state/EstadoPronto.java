package br.com.hamburgueria.state;

public class EstadoPronto implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) {
        System.out.println("Pedido ja esta pronto.");
    }

    @Override
    public void preparar(ContextoPedido contexto) {
        System.out.println("Pedido ja esta pronto.");
    }

    @Override
    public void entregar(ContextoPedido contexto) {
        System.out.println("Pedido entregue ao cliente!");
        contexto.setEstado(new EstadoEntregue());
    }

    @Override
    public void cancelar(ContextoPedido contexto) {
        System.out.println("Nao e possivel cancelar um pedido ja pronto.");
    }

    @Override
    public String getStatus() { return "Pronto"; }
}
