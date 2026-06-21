package br.com.hamburgueria.atendimento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PainelDeChamadaTest {

    @Test
    void painelColocaEmPreparo() {
        FilaDePedidos fila = new FilaDePedidos();
        PainelDeChamada painel = new PainelDeChamada();
        fila.adicionarObserver(painel);
        fila.novoPedido("Smash #1");
        assertTrue(painel.getEmPreparo().contains("Smash #1"));
    }

    @Test
    void painelMoveParaRetirada() {
        FilaDePedidos fila = new FilaDePedidos();
        PainelDeChamada painel = new PainelDeChamada();
        fila.adicionarObserver(painel);
        fila.novoPedido("Smash #1");
        fila.pedidoPronto("Smash #1");
        assertTrue(painel.getProntosParaRetirada().contains("Smash #1"));
    }

    @Test
    void painelGuardaUltimoChamado() {
        FilaDePedidos fila = new FilaDePedidos();
        PainelDeChamada painel = new PainelDeChamada();
        fila.adicionarObserver(painel);
        fila.pedidoPronto("Vegano #7");
        assertEquals("Vegano #7", painel.getUltimoChamado());
    }

    @Test
    void painelRemoveDeEmPreparo() {
        FilaDePedidos fila = new FilaDePedidos();
        PainelDeChamada painel = new PainelDeChamada();
        fila.adicionarObserver(painel);
        fila.novoPedido("Classico #2");
        fila.pedidoPronto("Classico #2");
        assertFalse(painel.getEmPreparo().contains("Classico #2"));
    }

}

