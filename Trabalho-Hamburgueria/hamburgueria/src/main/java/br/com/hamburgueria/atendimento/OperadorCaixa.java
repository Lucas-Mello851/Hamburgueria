package br.com.hamburgueria.atendimento;

import java.util.ArrayDeque;
import java.util.Deque;

public class OperadorCaixa {

    private Deque<OperacaoCaixa> historico = new ArrayDeque<>();

    public void executar(OperacaoCaixa comando) {
        comando.executar();
        historico.push(comando);
    }

    public boolean desfazerUltimo() {
        if (historico.isEmpty()) {
            return false;
        }
        OperacaoCaixa ultimo = historico.pop();
        ultimo.desfazer();
        return true;
    }

    public int getTotalOperacoes() {
        return historico.size();
    }
}
