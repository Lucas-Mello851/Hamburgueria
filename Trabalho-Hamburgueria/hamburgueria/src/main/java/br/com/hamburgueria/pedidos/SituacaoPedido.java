package br.com.hamburgueria.pedidos;

public interface SituacaoPedido {
    void confirmar(CicloPedido contexto);
    void preparar(CicloPedido contexto);
    void entregar(CicloPedido contexto);
    void cancelar(CicloPedido contexto);
    String getStatus();
}
