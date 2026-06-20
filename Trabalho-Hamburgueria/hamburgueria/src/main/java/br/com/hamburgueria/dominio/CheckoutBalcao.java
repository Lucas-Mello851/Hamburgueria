package br.com.hamburgueria.dominio;

public class CheckoutBalcao extends ProcessoCheckout {

    @Override
    protected String nomeDoCanal() {
        return "Balcao";
    }

    @Override
    protected double aplicarTaxaDoCanal(double total) {
        return total;
    }

    @Override
    protected String confirmar(Pedido pedido, double totalFinal) {
        return "Pedido confirmado no balcao. Retire no painel quando chamar. Total: R$ "
                + String.format("%.2f", totalFinal);
    }
}

