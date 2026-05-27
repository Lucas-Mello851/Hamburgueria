package br.com.hamburgueria.state;

public interface EstadoPedido {
    void confirmar(ContextoPedido contexto);
    void preparar(ContextoPedido contexto);
    void entregar(ContextoPedido contexto);
    void cancelar(ContextoPedido contexto);
    String getStatus();
}
