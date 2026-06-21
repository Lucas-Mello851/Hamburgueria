package br.com.hamburgueria.dominio;

import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.produtos.Lanche;
import br.com.hamburgueria.ingredientes.FichaTecnica;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.pagamento.PagamentoPix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ProcessoCheckoutTest {

    private Pedido novoPedido() {
        Lanche l = new HamburguerClassico();
        FichaTecnica f = FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 1, 1, 1);
        return new Pedido(l, f);
    }

    @Test
    void balcaoSemTaxa() {
        Pedido p = novoPedido();
        double esperado = p.getTotal();
        ProcessoCheckout.ResultadoCheckout r = new CheckoutBalcao().finalizar(p, new PagamentoPix());
        assertEquals(esperado, r.getTotalFinal());
        assertEquals("Balcao", r.getCanal());
        assertTrue(r.isAprovado());
    }

    @Test
    void deliveryComTaxa() {
        Pedido p = novoPedido();
        double semTaxa = p.getTotal();
        ProcessoCheckout.ResultadoCheckout r =
                new CheckoutDelivery("Rua A, 100").finalizar(p, new PagamentoPix());
        assertTrue(r.getTotalFinal() > semTaxa);
        assertEquals("Delivery", r.getCanal());
    }

    @Test
    void checkoutAvancaEstado() {
        Pedido p = novoPedido();
        assertEquals("Aguardando confirmacao", p.getStatus());
        new CheckoutBalcao().finalizar(p, new PagamentoPix());
        assertEquals("Em preparo", p.getStatus());
    }

    @Test
    void confirmacaoDeliveryComEndereco() {
        Pedido p = novoPedido();
        ProcessoCheckout.ResultadoCheckout r =
                new CheckoutDelivery("Av. Brasil, 500").finalizar(p, new PagamentoPix());
        assertTrue(r.getMensagem().contains("Av. Brasil, 500"));
    }

    @Test
    void validacaoRejeitaInvalido() {
        assertThrows(IllegalStateException.class,
                () -> new CheckoutBalcao().finalizar(null, new PagamentoPix()));
    }
}

