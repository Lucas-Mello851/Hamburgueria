package br.com.hamburgueria.observer;

public interface PedidoObserver {
    void atualizar(String evento, String descricaoPedido);
}
