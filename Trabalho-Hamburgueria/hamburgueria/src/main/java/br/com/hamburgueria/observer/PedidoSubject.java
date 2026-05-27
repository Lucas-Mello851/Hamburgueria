package br.com.hamburgueria.observer;

public interface PedidoSubject {
    void adicionarObserver(PedidoObserver observer);
    void removerObserver(PedidoObserver observer);
    void notificarObservers(String evento, String descricaoPedido);
}
