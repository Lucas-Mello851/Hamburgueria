package br.com.hamburgueria.observer;

import java.util.ArrayList;
import java.util.List;

public class FilaPedidos implements PedidoSubject {

    private List<PedidoObserver> observers;
    private String ultimoPedido;

    public FilaPedidos() {
        observers = new ArrayList<>();
    }

    @Override
    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(PedidoObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String evento, String descricaoPedido) {
        for (int i = 0; i < observers.size(); i++) {
            PedidoObserver observer = observers.get(i);
            observer.atualizar(evento, descricaoPedido);
        }
    }

    public void novoPedido(String descricao) {
        this.ultimoPedido = descricao;
        notificarObservers("NOVO_PEDIDO", descricao);
    }

    public void pedidoPronto(String descricao) {
        notificarObservers("PEDIDO_PRONTO", descricao);
    }
}
