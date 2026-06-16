package Classes;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public boolean processar(double valor) {
        System.out.printf("Pagamento em dinheiro: R$ %.2f recebido.%n", valor);
        return true;
    }

    @Override
    public String getNome() { return "Dinheiro"; }
}
