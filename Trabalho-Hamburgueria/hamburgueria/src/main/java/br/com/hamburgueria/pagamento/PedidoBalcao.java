package br.com.hamburgueria.pagamento;

public class PedidoBalcao extends PedidoEntrega {

    private String descricao;
    private double total;

    public PedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.total = total;
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
}
