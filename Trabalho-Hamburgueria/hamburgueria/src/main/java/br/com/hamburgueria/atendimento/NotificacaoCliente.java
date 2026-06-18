package br.com.hamburgueria.atendimento;

public class NotificacaoCliente implements AcompanhantepPedido {

    private final String nomeCliente;
    private boolean notificado = false;

    public NotificacaoCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        if ("PEDIDO_PRONTO".equals(evento)) {
            this.notificado = true;
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean foiNotificado() {
        return notificado;
    }
}
