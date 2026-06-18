package br.com.hamburgueria.pedidos;

import java.util.ArrayList;
import java.util.List;

public class LeitorPedidoTexto {

    private List<RegraTextoPedido> expressoes;

    public LeitorPedidoTexto() {
        expressoes = new ArrayList<>();
        expressoes.add(new RegraTipoLanche());
        expressoes.add(new RegraRemocao());
        expressoes.add(new RegraAdicional());
    }

    public PedidoTextoLido interpretar(String texto) {
        PedidoTextoLido contexto = new PedidoTextoLido(texto);
        for (RegraTextoPedido expressao : expressoes) {
            expressao.interpretar(contexto);
        }
        return contexto;
    }
}
