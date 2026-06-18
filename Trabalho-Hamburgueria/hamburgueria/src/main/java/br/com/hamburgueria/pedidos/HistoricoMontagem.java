package br.com.hamburgueria.pedidos;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoMontagem {

    private final Deque<RegistroMontagem> pilha = new ArrayDeque<>();

    public void salvar(RegistroMontagem estado) {
        pilha.push(estado);
    }

    public RegistroMontagem desfazer() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("Nenhum estado anterior disponivel.");
        }
        return pilha.pop();
    }

    public boolean temHistorico() {
        return !pilha.isEmpty();
    }

    public int getTamanho() {
        return pilha.size();
    }
}
