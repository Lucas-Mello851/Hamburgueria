package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.produtos.Lanche;

public class PedidoBalcao extends PedidoEntrega {

    private String descricao;
    private double total;
    private Lanche lanche;

    public PedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.total = total;
    }

    public PedidoBalcao(Lanche lanche, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.lanche = lanche;
        this.descricao = lanche.getDescricao();
        this.total = lanche.getPreco();
    }

    @Override
    public boolean finalizar() {
        return formaPagamento.processar(total);
    }

    @Override
    public double getTotal() {
        return total;
    }

    public String getDescricao() {
        return descricao;
    }

    public Lanche getLanche() {
        return lanche;
    }
}

