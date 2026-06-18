package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.pedidos.CicloPedido;



public class OperacaoCancelarPedido implements OperacaoCaixa {

    private CicloPedido contextoPedido;
    private String statusAnterior;

    public OperacaoCancelarPedido(CicloPedido contextoPedido) {
        this.contextoPedido = contextoPedido;
    }

    @Override
    public void executar() {
        statusAnterior = contextoPedido.getStatus();
        contextoPedido.cancelar();
    }

    @Override
    public void desfazer() {
    }
}
