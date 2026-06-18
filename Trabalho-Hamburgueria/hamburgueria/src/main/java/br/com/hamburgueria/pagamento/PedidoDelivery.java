package br.com.hamburgueria.pagamento;

public class PedidoDelivery extends PedidoEntrega {

    private final String descricao;
    private final double total;
    private final String endereco;

    public PedidoDelivery(String descricao, double total, String endereco, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.total = total;
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
}
