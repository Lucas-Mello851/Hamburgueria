package br.com.hamburgueria.pagamento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoPagamentosTest {

    private final CatalogoPagamentos cat = new CatalogoPagamentos();

    @Test
    void pix() {
        assertInstanceOf(PagamentoPix.class, cat.obter("PIX"));
    }

    @Test
    void dinheiro() {
        assertInstanceOf(PagamentoDinheiro.class, cat.dinheiro());
    }

    @Test
    void cartoes() {
        assertInstanceOf(PagamentoCartao.class, cat.cartaoCredito());
        assertInstanceOf(PagamentoCartao.class, cat.cartaoDebito());
    }

    @Test
    void minuscula() {
        assertNotNull(cat.obter("pix"));
    }

    @Test
    void maquininha() {
        assertNotNull(cat.maquininhaParceira("Cielo"));
    }

    @Test
    void desconhecida() {
        assertThrows(IllegalArgumentException.class, () -> cat.obter("BITCOIN"));
    }

    @Test
    void total() {
        assertEquals(4, cat.getTotalFormas());
    }
}
