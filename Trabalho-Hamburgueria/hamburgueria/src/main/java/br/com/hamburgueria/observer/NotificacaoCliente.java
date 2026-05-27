package br.com.hamburgueria.observer;

public class NotificacaoCliente implements PedidoObserver {

    private final String nomeCliente;

    public NotificacaoCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[Notificacao] " + nomeCliente + ", seu pedido esta pronto: " + descricaoPedido);
        }
    }
}
