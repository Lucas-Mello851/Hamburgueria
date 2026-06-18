package br.com.hamburgueria.atendimento;

public class MonitorCozinha implements AcompanhantepPedido {

    private String ultimaNotificacao;

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        if ("NOVO_PEDIDO".equals(evento)) {
            this.ultimaNotificacao = descricaoPedido;
        }
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
