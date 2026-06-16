package Classes;

public class PedidoBalcao extends Pedido {

    private String descricao;

    public PedidoBalcao(String descricao, double total, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.tipoLanche = descricao;
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
}
