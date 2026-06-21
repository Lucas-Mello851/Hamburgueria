package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.pedidos.PedidoMontado;

public class ReciboPagamento {

    private final PedidoMontado pedido;
    private final FormaPagamento forma;
    private final double valorPago;
    private final boolean aprovado;

    public ReciboPagamento(PedidoMontado pedido, FormaPagamento forma, double valor) {
        this.pedido = pedido;
        this.forma = forma;
        this.valorPago = valor;
        this.aprovado = forma.processar(valor);
    }

    public PedidoMontado getPedido() {
        return pedido;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public double getValorPago() {
        return valorPago;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public String descrever() {
        return "Recibo: " + pedido.getTipoLanche()
                + " | " + forma.getNome()
                + " | R$ " + String.format("%.2f", valorPago)
                + " | " + (aprovado ? "APROVADO" : "RECUSADO");
    }
}
