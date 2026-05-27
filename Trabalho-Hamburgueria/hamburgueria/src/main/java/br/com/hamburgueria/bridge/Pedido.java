package br.com.hamburgueria.bridge;

public abstract class Pedido {

    protected FormaPagamento formaPagamento;

    public Pedido(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public abstract void finalizar();
    public abstract double getTotal();
}
