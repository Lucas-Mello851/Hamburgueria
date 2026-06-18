package br.com.hamburgueria.atendimento;

public interface PedidoMonitoravel {
    void adicionarObserver(AcompanhantepPedido observer);
    void removerObserver(AcompanhantepPedido observer);
    void notificarObservers(String evento, String descricaoPedido);
}
