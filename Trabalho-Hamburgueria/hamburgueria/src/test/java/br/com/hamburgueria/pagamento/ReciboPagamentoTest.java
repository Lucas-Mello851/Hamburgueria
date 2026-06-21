package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.pedidos.MontadorPedido;
import br.com.hamburgueria.pedidos.PedidoMontado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ReciboPagamentoTest {

    private PedidoMontado pedido() {
        return new MontadorPedido().setTipoLanche("Classico").setFormaPagamento("Pix").build();
    }

    @Test
    void aprovado() {
        ReciboPagamento r = new ReciboPagamento(pedido(), new PagamentoPix(), 22.0);
        assertTrue(r.isAprovado());
        assertEquals("Classico", r.getPedido().getTipoLanche());
        assertEquals(22.0, r.getValorPago());
    }

    @Test
    void forma() {
        ReciboPagamento r = new ReciboPagamento(pedido(), new PagamentoDinheiro(), 30.0);
        assertNotNull(r.getForma());
        assertTrue(r.descrever().contains("Classico"));
    }
}
