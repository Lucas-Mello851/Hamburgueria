package br.com.hamburgueria.observer;

public class MonitorCozinha implements PedidoObserver {

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        if ("NOVO_PEDIDO".equals(evento)) {
            System.out.println("[Cozinha] Novo pedido chegou: " + descricaoPedido);
        }
    }
}
