package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.CentralAtendimentoRestaurante;
import br.com.hamburgueria.atendimento.Cozinha;
import br.com.hamburgueria.atendimento.Entregador;
import br.com.hamburgueria.atendimento.PostoCaixa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CentralAtendimentoTest {

    @Test
    @DisplayName("Mediator: registrar pedido confirma a entrega no caixa")
    void mediatorEntregaConfirmada() {
        PostoCaixa caixa = new PostoCaixa();
        CentralAtendimentoRestaurante mediator = new CentralAtendimentoRestaurante(new Cozinha(), caixa, new Entregador());
        caixa.registrarPedido("Smash");
        assertTrue(caixa.isEntregaConfirmada());
    }

    @Test
    @DisplayName("Mediator: registrar pedido gera eventos no mediator")
    void mediatorEventos() {
        PostoCaixa caixa = new PostoCaixa();
        CentralAtendimentoRestaurante mediator = new CentralAtendimentoRestaurante(new Cozinha(), caixa, new Entregador());
        caixa.registrarPedido("Smash");
        assertFalse(mediator.getEventosRegistrados().isEmpty());
    }

    @Test
    @DisplayName("Mediator: cozinha guarda o pedido atual recebido")
    void mediatorPedidoAtual() {
        Cozinha cozinha = new Cozinha();
        PostoCaixa caixa = new PostoCaixa();
        new CentralAtendimentoRestaurante(cozinha, caixa, new Entregador());
        caixa.registrarPedido("Vegano");
        assertEquals("Vegano", cozinha.getPedidoAtual());
    }

}