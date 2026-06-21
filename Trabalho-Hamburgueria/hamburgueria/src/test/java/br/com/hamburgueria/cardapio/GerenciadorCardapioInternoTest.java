package br.com.hamburgueria.cardapio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorCardapioInternoTest {

    @Test
    void adiciona() {
        GerenciadorCardapioInterno g = new GerenciadorCardapioInterno();
        int antes = g.getTotalItens();
        assertTrue(g.adicionarItem("Picles", 2.0));
        assertEquals(antes + 1, g.getTotalItens());
        assertTrue(g.contemItem("Picles"));
    }

    @Test
    void removeExistente() {
        GerenciadorCardapioInterno g = new GerenciadorCardapioInterno();
        g.adicionarItem("Picles", 2.0);
        assertTrue(g.removerItem("Picles"));
    }

    @Test
    void removeInexistente() {
        assertFalse(new GerenciadorCardapioInterno().removerItem("NaoExiste"));
    }

    @Test
    void alteraExistente() {
        GerenciadorCardapioInterno g = new GerenciadorCardapioInterno();
        g.adicionarItem("Picles", 2.0);
        assertTrue(g.alterarPreco("Picles", 3.0));
    }

    @Test
    void alteraInexistente() {
        assertFalse(new GerenciadorCardapioInterno().alterarPreco("NaoExiste", 5.0));
    }

    @Test
    void naoContem() {
        assertFalse(new GerenciadorCardapioInterno().contemItem("Fantasma"));
    }
}
