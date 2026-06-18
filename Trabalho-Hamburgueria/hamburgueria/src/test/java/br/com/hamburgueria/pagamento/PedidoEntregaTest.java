package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.pagamento.PagamentoCartao;
import br.com.hamburgueria.pagamento.PagamentoDinheiro;
import br.com.hamburgueria.pagamento.PagamentoPix;
import br.com.hamburgueria.pagamento.PedidoBalcao;
import br.com.hamburgueria.pagamento.PedidoDelivery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PedidoEntregaTest {

    @Test
    @DisplayName("Bridge: pedido balcao com pix e aprovado")
    void bridgeBalcaoPix() {
        assertTrue(new PedidoBalcao("Classico", 22.0, new PagamentoPix()).finalizar());
    }

    @Test
    @DisplayName("Bridge: pedido balcao com dinheiro e aprovado")
    void bridgeBalcaoDinheiro() {
        assertTrue(new PedidoBalcao("Classico", 22.0, new PagamentoDinheiro()).finalizar());
    }

    @Test
    @DisplayName("Bridge: pedido delivery com cartao e aprovado")
    void bridgeDeliveryCartao() {
        assertTrue(new PedidoDelivery("Smash", 35.0, "Rua A", new PagamentoCartao("Credito")).finalizar());
    }

    @Test
    @DisplayName("Bridge: getTotal retorna o valor do pedido")
    void bridgeGetTotal() {
        assertEquals(39.0, new PedidoDelivery("Smash", 39.0, "Rua B", new PagamentoPix()).getTotal());
    }

    @Test
    @DisplayName("Bridge: trocar forma de pagamento mantem aprovacao")
    void bridgeTrocaPagamento() {
        PedidoBalcao pedido = new PedidoBalcao("Vegano", 26.0, new PagamentoDinheiro());
        pedido.setFormaPagamento(new PagamentoPix());
        assertTrue(pedido.finalizar());
    }

    @Test
    @DisplayName("Bridge: nome do pagamento pix")
    void bridgeNomePix() {
        assertEquals("PIX", new PagamentoPix().getNome());
    }

    @Test
    @DisplayName("Bridge: nome do pagamento cartao inclui o tipo")
    void bridgeNomeCartao() {
        assertTrue(new PagamentoCartao("Credito").getNome().contains("Credito"));
    }

}