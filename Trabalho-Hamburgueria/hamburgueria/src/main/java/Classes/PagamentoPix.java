package Classes;

public class PagamentoPix implements FormaPagamento {

    @Override
    public boolean processar(double valor) {
        System.out.printf("PIX recebido: R$ %.2f. Confirmando...%n", valor);
        return true;
    }

    @Override
    public String getNome() { return "PIX"; }
}
