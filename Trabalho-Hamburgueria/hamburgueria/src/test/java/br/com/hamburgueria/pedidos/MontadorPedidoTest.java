package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.MontadorPedido;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MontadorPedidoTest {

    @Test
    @DisplayName("Builder: define o tipo do lanche")
    void builderTipo() {
        assertEquals("Classico", new MontadorPedido().setTipoLanche("Classico").build().getTipoLanche());
    }

    @Test
    @DisplayName("Builder: adiciona queijo aos adicionais")
    void builderQueijo() {
        assertTrue(new MontadorPedido().setTipoLanche("Classico").adicionarQueijo().build()
                .getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    @DisplayName("Builder: adiciona bacon aos adicionais")
    void builderBacon() {
        assertTrue(new MontadorPedido().setTipoLanche("Classico").adicionarBacon().build()
                .getAdicionais().contains("Bacon Crocante"));
    }

    @Test
    @DisplayName("Builder: define observacao")
    void builderObservacao() {
        assertEquals("sem cebola", new MontadorPedido().setTipoLanche("Smash").setObservacao("sem cebola").build().getObservacao());
    }

    @Test
    @DisplayName("Builder: define forma de pagamento")
    void builderFormaPagamento() {
        assertEquals("PIX", new MontadorPedido().setTipoLanche("Smash").setFormaPagamento("PIX").build().getFormaPagamento());
    }

    @Test
    @DisplayName("Builder: forma de pagamento padrao e dinheiro")
    void builderFormaPagamentoPadrao() {
        assertEquals("Dinheiro", new MontadorPedido().setTipoLanche("Smash").build().getFormaPagamento());
    }

    @Test
    @DisplayName("Builder: sem tipo lanca excecao")
    void builderSemTipo() {
        assertThrows(IllegalStateException.class, () -> new MontadorPedido().build());
    }

    @Test
    @DisplayName("Builder: pedido sem adicionais tem lista vazia")
    void builderSemAdicionais() {
        assertTrue(new MontadorPedido().setTipoLanche("Vegano").build().getAdicionais().isEmpty());
    }

}