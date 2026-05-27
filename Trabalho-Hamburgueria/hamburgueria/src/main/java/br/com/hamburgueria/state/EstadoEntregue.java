package br.com.hamburgueria.state;

public class EstadoEntregue implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) { System.out.println("Pedido ja foi entregue."); }

    @Override
    public void preparar(ContextoPedido contexto)  { System.out.println("Pedido ja foi entregue."); }

    @Override
    public void entregar(ContextoPedido contexto)  { System.out.println("Pedido ja foi entregue."); }

    @Override
    public void cancelar(ContextoPedido contexto)  { System.out.println("Nao e possivel cancelar pedido ja entregue."); }

    @Override
    public String getStatus() { return "Entregue"; }
}
