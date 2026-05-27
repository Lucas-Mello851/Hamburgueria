package br.com.hamburgueria.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoPedido {

    private final Deque<EstadoPedidoMemento> pilha = new ArrayDeque<>();

    public void salvar(EstadoPedidoMemento estado) {
        pilha.push(estado);
        System.out.println("Estado salvo. Historico tem " + pilha.size() + " ponto(s).");
    }

    public EstadoPedidoMemento desfazer() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("Nenhum estado anterior disponivel.");
        }
        EstadoPedidoMemento estado = pilha.pop();
        System.out.println("Desfazendo... Historico restante: " + pilha.size() + " ponto(s).");
        return estado;
    }

    public boolean temHistorico() {
        return !pilha.isEmpty();
    }

    public int getTamanho() {
        return pilha.size();
    }
}
