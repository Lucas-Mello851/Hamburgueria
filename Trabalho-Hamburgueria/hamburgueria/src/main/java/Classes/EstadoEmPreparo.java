package Classes;

public class EstadoEmPreparo implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) {
        System.out.println("Pedido ja esta em preparo.");
    }

    @Override
    public void preparar(ContextoPedido contexto) {
        System.out.println("Cozinha preparando o pedido...");
        contexto.setEstado(new EstadoPronto());
    }

    @Override
    public void entregar(ContextoPedido contexto) {
        System.out.println("Pedido ainda nao esta pronto.");
    }

    @Override
    public void cancelar(ContextoPedido contexto) {
        System.out.println("Pedido cancelado durante o preparo.");
        contexto.setEstado(new EstadoCancelado());
    }

    @Override
    public void pausar(ContextoPedido contexto) {
        System.out.println("Faltou ingrediente! Pausando o preparo...");
        contexto.setEstado(new EstadoEmEspera());
    }

    @Override
    public String getStatus() { return "Em preparo"; }
}
