package br.com.hamburgueria.observer;

public class MonitorCaixa implements PedidoObserver {

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        System.out.println("[Caixa] Evento '" + evento + "' para: " + descricaoPedido);
    }
}
