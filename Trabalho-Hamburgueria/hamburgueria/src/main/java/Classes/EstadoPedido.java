package Classes;

public interface EstadoPedido {
    void confirmar(ContextoPedido contexto);
    void preparar(ContextoPedido contexto);
    void entregar(ContextoPedido contexto);
    void cancelar(ContextoPedido contexto);

    default void pausar(ContextoPedido contexto) {
        System.out.println("Pedido nao pode ser pausado no estado atual: " + getStatus());
    }

    default void retomar(ContextoPedido contexto) {
        System.out.println("Pedido nao esta pausado.");
    }
    String getStatus();
}
