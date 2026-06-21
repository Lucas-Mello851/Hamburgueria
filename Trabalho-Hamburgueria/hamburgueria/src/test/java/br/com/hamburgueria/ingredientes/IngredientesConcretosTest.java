package br.com.hamburgueria.ingredientes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class IngredientesConcretosTest {

    @Test
    void blendBovino() {
        BlendBovino c = new BlendBovino();
        assertEquals("Blend Bovino 160g", c.getDescricao());
        assertEquals(160.0, c.getPeso());
    }

    @Test
    void blendGrao() {
        BlendGraoDeBico c = new BlendGraoDeBico();
        assertEquals("Blend Grao-de-Bico 150g", c.getDescricao());
        assertEquals(150.0, c.getPeso());
    }

    @Test
    void smashDuplo() {
        SmashDuplo c = new SmashDuplo();
        assertEquals("2x Smash 80g", c.getDescricao());
        assertEquals(160.0, c.getPeso());
    }

    @Test
    void paoBrioche() { assertEquals("Pao Brioche", new PaoBrioche().getDescricao()); }

    @Test
    void paoIntegral() { assertEquals("Pao Integral", new PaoIntegral().getDescricao()); }

    @Test
    void paoPotato() { assertEquals("Pao Potato", new PaoPotato().getDescricao()); }

    @Test
    void maionese() { assertEquals("Maionese Caseira", new MaioneseCaseira().getDescricao()); }

    @Test
    void molhoSmash() { assertEquals("Molho Smash Especial", new MolhoSmash().getDescricao()); }

    @Test
    void molhoVegano() { assertEquals("Molho Vegano de Tahine", new MolhoVegano().getDescricao()); }

    @Test
    void compartilhado() {
        IngredienteCompartilhadoImpl i = new IngredienteCompartilhadoImpl("Pao Brioche", "Pao");
        assertEquals("Pao Brioche", i.getDescricao());
        assertEquals("Pao", i.getTipo());
    }
}
