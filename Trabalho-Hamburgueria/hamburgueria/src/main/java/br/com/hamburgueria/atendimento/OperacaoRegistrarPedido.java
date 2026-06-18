package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.pedidos.PedidoMontado;

import br.com.hamburgueria.pedidos.CicloPedido;
import br.com.hamburgueria.pedidos.MontadorPedido;



public class OperacaoRegistrarPedido implements OperacaoCaixa {

    private String tipoLanche;
    private CicloPedido contextoPedido;
    private PedidoMontado pedidoRegistrado;

    public OperacaoRegistrarPedido(String tipoLanche, CicloPedido contextoPedido) {
        this.tipoLanche = tipoLanche;
        this.contextoPedido = contextoPedido;
    }

    @Override
    public void executar() {
        pedidoRegistrado = new MontadorPedido()
                .setTipoLanche(tipoLanche)
                .setFormaPagamento("Pendente")
                .build();
        contextoPedido.confirmar();
    }

    @Override
    public void desfazer() {
        contextoPedido.cancelar();
    }

    public PedidoMontado getPedidoRegistrado() {
        return pedidoRegistrado;
    }
}
