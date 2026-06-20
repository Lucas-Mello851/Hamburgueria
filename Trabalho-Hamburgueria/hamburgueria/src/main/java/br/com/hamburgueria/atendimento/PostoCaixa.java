package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.pagamento.ReciboPagamento;
import br.com.hamburgueria.pagamento.FormaPagamento;
import br.com.hamburgueria.pedidos.PedidoMontado;
import br.com.hamburgueria.pedidos.MontadorPedido;

public class PostoCaixa {

    private CentralAtendimento mediator;
    private boolean entregaConfirmada = false;
    private ReciboPagamento ultimoRecibo;

    public void setMediator(CentralAtendimento mediator) {
        this.mediator = mediator;
    }

    public void registrarPedido(String pedido) {
        mediator.notificar(this, "pedido_registrado:" + pedido);
    }

    public ReciboPagamento emitirRecibo(String tipoLanche, FormaPagamento forma, double valor) {
        PedidoMontado montado = new MontadorPedido()
                .setTipoLanche(tipoLanche)
                .setFormaPagamento(forma.getNome())
                .build();
        this.ultimoRecibo = new ReciboPagamento(montado, forma, valor);
        return ultimoRecibo;
    }

    public ReciboPagamento getUltimoRecibo() {
        return ultimoRecibo;
    }

    public void confirmarEntrega() {
        this.entregaConfirmada = true;
    }

    public boolean isEntregaConfirmada() {
        return entregaConfirmada;
    }
}

