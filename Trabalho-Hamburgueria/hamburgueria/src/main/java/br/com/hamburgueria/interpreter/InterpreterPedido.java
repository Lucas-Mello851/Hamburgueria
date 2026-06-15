package br.com.hamburgueria.interpreter;

import java.util.ArrayList;
import java.util.List;

public class InterpreterPedido {

    private List<ExpressaoPedido> expressoes;

    public InterpreterPedido() {
        expressoes = new ArrayList<>();
        expressoes.add(new InterpretadorTipoLanche());
        expressoes.add(new InterpretadorRemocao());
        expressoes.add(new InterpretadorAdicional());
    }

    public ContextoPedidoTexto interpretar(String texto) {
        ContextoPedidoTexto contexto = new ContextoPedidoTexto(texto);
        for (ExpressaoPedido expressao : expressoes) {
            expressao.interpretar(contexto);
        }
        return contexto;
    }
}
