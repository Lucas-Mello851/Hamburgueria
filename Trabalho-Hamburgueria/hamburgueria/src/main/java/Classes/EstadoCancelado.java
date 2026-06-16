package Classes;

public class EstadoCancelado implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) { System.out.println("Pedido esta cancelado."); }

    @Override
    public void preparar(ContextoPedido contexto)  { System.out.println("Pedido esta cancelado."); }

    @Override
    public void entregar(ContextoPedido contexto)  { System.out.println("Pedido esta cancelado."); }

    @Override
    public void cancelar(ContextoPedido contexto)  { System.out.println("Pedido ja esta cancelado."); }

    @Override
    public String getStatus() { return "Cancelado"; }
}
