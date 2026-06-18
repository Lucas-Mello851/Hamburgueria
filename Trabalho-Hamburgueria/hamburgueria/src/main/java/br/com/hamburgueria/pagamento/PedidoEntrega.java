package br.com.hamburgueria.pagamento;

public abstract class PedidoEntrega {

    protected FormaPagamento formaPagamento;

    public PedidoEntrega(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public abstract boolean finalizar();
    public abstract double getTotal();
}
