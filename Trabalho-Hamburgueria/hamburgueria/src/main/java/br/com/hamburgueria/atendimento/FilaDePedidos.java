package br.com.hamburgueria.atendimento;

import java.util.ArrayList;
import java.util.List;

public class FilaDePedidos implements PedidoMonitoravel {

    private List<AcompanhantepPedido> observers;
    private String ultimoPedido;

    public FilaDePedidos() {
        observers = new ArrayList<>();
    }

    @Override
    public void adicionarObserver(AcompanhantepPedido observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(AcompanhantepPedido observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String evento, String descricaoPedido) {
        for (int i = 0; i < observers.size(); i++) {
            AcompanhantepPedido observer = observers.get(i);
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
