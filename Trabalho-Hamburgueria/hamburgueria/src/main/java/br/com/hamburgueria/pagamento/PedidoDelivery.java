package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.produtos.Lanche;

public class PedidoDelivery extends PedidoEntrega {

    private final String descricao;
    private final double total;
    private final String endereco;
    private Lanche lanche;

    public PedidoDelivery(String descricao, double total, String endereco, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.total = total;
        this.endereco = endereco;
    }

    public PedidoDelivery(Lanche lanche, String endereco, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.lanche = lanche;
        this.descricao = lanche.getDescricao();
        this.total = lanche.getPreco();
        this.endereco = endereco;
    }

    @Override
    public boolean finalizar() {
        return formaPagamento.processar(total);
    }

    @Override
    public double getTotal() {
        return total;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Lanche getLanche() {
        return lanche;
    }
}

