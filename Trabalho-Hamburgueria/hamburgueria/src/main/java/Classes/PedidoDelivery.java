package Classes;

public class PedidoDelivery extends Pedido {

    private final String descricao;
    private final String endereco;

    public PedidoDelivery(String descricao, double total, String endereco, FormaPagamento formaPagamento) {
        super(formaPagamento);
        this.descricao = descricao;
        this.tipoLanche = descricao;
        this.total = total;
        this.endereco = endereco;
    }

    @Override
    public void finalizar() {
        System.out.println("Pedido delivery para " + endereco + ": " + descricao);
        formaPagamento.processar(total);
    }
}
