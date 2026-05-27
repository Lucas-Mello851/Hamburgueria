package br.com.hamburgueria.bridge;

public class PedidoBalcao extends Pedido {

    private String descricao;
    private double total;

    public PedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.total = total;
    }

    @Override
    public void finalizar() {
        System.out.println("Pedido no balcao: " + descricao);
        boolean pagamentoOk = formaPagamento.processar(total);
        if (!pagamentoOk) {
            System.out.println("Erro no pagamento!");
        }
    }

    @Override
    public double getTotal() {
        return total;
    }
}
