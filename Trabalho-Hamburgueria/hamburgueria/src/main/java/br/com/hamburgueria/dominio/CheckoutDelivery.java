package br.com.hamburgueria.dominio;

import br.com.hamburgueria.cardapio.Precos;

public class CheckoutDelivery extends ProcessoCheckout {

    private final String endereco;

    public CheckoutDelivery(String endereco) {
        this.endereco = endereco;
    }

    @Override
    protected String nomeDoCanal() {
        return "Delivery";
    }

    @Override
    protected double aplicarTaxaDoCanal(double total) {
        return total + Precos.TAXA_ENTREGA_DELIVERY;
    }

    @Override
    protected String confirmar(Pedido pedido, double totalFinal) {
        return "Pedido confirmado para entrega em " + endereco
                + ". Total com entrega: R$ " + String.format("%.2f", totalFinal);
    }

    public String getEndereco() {
        return endereco;
    }
}

