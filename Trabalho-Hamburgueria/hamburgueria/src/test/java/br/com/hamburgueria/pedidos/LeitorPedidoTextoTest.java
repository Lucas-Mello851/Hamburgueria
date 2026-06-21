package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.LeitorPedidoTexto;
import br.com.hamburgueria.pedidos.PedidoTextoLido;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LeitorPedidoTextoTest {

    @Test
    void interpreterTipo() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("quero um smash com queijo");
        assertEquals("Smash", ctx.getTipoLanche());
    }

    @Test
    void interpreterQueijo() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("smash com queijo");
        assertTrue(ctx.getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    void interpreterBacon() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("smash com bacon");
        assertTrue(ctx.getAdicionais().contains("Bacon Crocante"));
    }

    @Test
    void interpreterRemoveTomate() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("classico sem tomate");
        assertTrue(ctx.getRemocoes().contains("Tomate"));
    }

    @Test
    void interpreterRemoveCebola() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("classico sem cebola");
        assertTrue(ctx.getRemocoes().contains("Cebola"));
    }

    @Test
    void interpreterTipoPadrao() {
        PedidoTextoLido ctx = new LeitorPedidoTexto().interpretar("um lanche com queijo");
        assertEquals("Clássico", ctx.getTipoLanche());
    }

}