package Classes;

public class EstadoEmEspera implements EstadoPedido {

    @Override
    public void confirmar(ContextoPedido contexto) {
        System.out.println("Pedido em espera aguardando reposicao de ingrediente.");
    }

    @Override
    public void preparar(ContextoPedido contexto) {
        System.out.println("Pedido em espera. Use retomar() apos repor o estoque.");
    }

    @Override
    public void entregar(ContextoPedido contexto) {
        System.out.println("Pedido em espera, ainda nao foi preparado.");
    }

    @Override
    public void cancelar(ContextoPedido contexto) {
        System.out.println("Pedido cancelado durante a espera por ingrediente.");
        contexto.setEstado(new EstadoCancelado());
    }

    @Override
    public void retomar(ContextoPedido contexto) {
        System.out.println("Ingrediente reposto. Retomando o preparo...");
        contexto.setEstado(new EstadoEmPreparo());
    }

    @Override
    public String getStatus() { return "Em espera"; }
}
