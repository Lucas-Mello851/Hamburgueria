package br.com.hamburgueria.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CaixaOperador {

    private Deque<Comando> historico = new ArrayDeque<>();

    public void executar(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimo() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operacao para desfazer.");
            return;
        }
        Comando ultimo = historico.pop();
        ultimo.desfazer();
    }

    public int getTotalOperacoes() {
        return historico.size();
    }
}
