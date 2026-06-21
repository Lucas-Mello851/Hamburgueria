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
    void builderTipo() {
        assertEquals("Classico", new MontadorPedido().setTipoLanche("Classico").build().getTipoLanche());
    }

    @Test
    void builderQueijo() {
        assertTrue(new MontadorPedido().setTipoLanche("Classico").adicionarQueijo().build()
                .getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    void builderBacon() {
        assertTrue(new MontadorPedido().setTipoLanche("Classico").adicionarBacon().build()
                .getAdicionais().contains("Bacon Crocante"));
    }

    @Test
    void builderObservacao() {
        assertEquals("sem cebola", new MontadorPedido().setTipoLanche("Smash").setObservacao("sem cebola").build().getObservacao());
    }

    @Test
    void builderFormaPagamento() {
        assertEquals("PIX", new MontadorPedido().setTipoLanche("Smash").setFormaPagamento("PIX").build().getFormaPagamento());
    }

    @Test
    void builderFormaPagamentoPadrao() {
        assertEquals("Dinheiro", new MontadorPedido().setTipoLanche("Smash").build().getFormaPagamento());
    }

    @Test
    void builderSemTipo() {
        assertThrows(IllegalStateException.class, () -> new MontadorPedido().build());
    }

    @Test
    void builderSemAdicionais() {
        assertTrue(new MontadorPedido().setTipoLanche("Vegano").build().getAdicionais().isEmpty());
    }

}