package br.com.hamburgueria.pedidos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class RegrasInterpreterTest {

    private PedidoTextoLido ctx(String txt) { return new PedidoTextoLido(txt); }

    @Test
    void tipoSmash() {
        PedidoTextoLido c = ctx("quero um smash");
        new RegraTipoLanche().interpretar(c);
        assertEquals("Smash", c.getTipoLanche());
    }

    @Test
    void tipoVegano() {
        PedidoTextoLido c = ctx("um vegano por favor");
        new RegraTipoLanche().interpretar(c);
        assertEquals("Vegano", c.getTipoLanche());
    }

    @Test
    void tipoClassico() {
        PedidoTextoLido c = ctx("um classico");
        new RegraTipoLanche().interpretar(c);
        assertEquals("Clássico", c.getTipoLanche());
    }

    @Test
    void tipoDefault() {
        PedidoTextoLido c = ctx("qualquer coisa");
        new RegraTipoLanche().interpretar(c);
        assertEquals("Clássico", c.getTipoLanche());
    }

    @Test
    void adicionalQueijo() {
        PedidoTextoLido c = ctx("com queijo");
        new RegraAdicional().interpretar(c);
        assertTrue(c.getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    void adicionalSemQueijo() {
        PedidoTextoLido c = ctx("sem queijo");
        new RegraAdicional().interpretar(c);
        assertFalse(c.getAdicionais().contains("Queijo Cheddar"));
    }

    @Test
    void adicionalVarios() {
        PedidoTextoLido c = ctx("com bacon alface tomate molho");
        new RegraAdicional().interpretar(c);
        assertTrue(c.getAdicionais().contains("Bacon Crocante"));
        assertTrue(c.getAdicionais().contains("Alface"));
        assertTrue(c.getAdicionais().contains("Tomate"));
        assertTrue(c.getAdicionais().contains("Molho Especial"));
    }

    @Test
    void remocaoTomate() {
        PedidoTextoLido c = ctx("sem tomate");
        new RegraRemocao().interpretar(c);
        assertTrue(c.getRemocoes().contains("Tomate"));
    }

    @Test
    void remocaoVarias() {
        PedidoTextoLido c = ctx("sem cebola sem alface sem molho");
        new RegraRemocao().interpretar(c);
        assertTrue(c.getRemocoes().contains("Cebola"));
        assertTrue(c.getRemocoes().contains("Alface"));
        assertTrue(c.getRemocoes().contains("Molho Especial"));
    }

    @Test
    void remocaoNenhuma() {
        PedidoTextoLido c = ctx("com tudo");
        new RegraRemocao().interpretar(c);
        assertTrue(c.getRemocoes().isEmpty());
    }
}
