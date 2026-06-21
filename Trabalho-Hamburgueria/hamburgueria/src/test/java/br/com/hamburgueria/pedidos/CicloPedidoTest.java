package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.CicloPedido;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CicloPedidoTest {

    @Test
    void stateInicial() {
        assertEquals("Aguardando confirmacao", new CicloPedido().getStatus());
    }

    @Test
    void stateConfirmar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        assertEquals("Em preparo", ctx.getStatus());
    }

    @Test
    void statePreparar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        assertEquals("Pronto", ctx.getStatus());
    }

    @Test
    void stateEntregar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        ctx.entregar();
        assertEquals("Entregue", ctx.getStatus());
    }

    @Test
    void stateCancelar() {
        CicloPedido ctx = new CicloPedido();
        ctx.cancelar();
        assertEquals("Cancelado", ctx.getStatus());
    }

    @Test
    void stateEntregarSemConfirmar() {
        CicloPedido ctx = new CicloPedido();
        ctx.entregar();
        assertEquals("Aguardando confirmacao", ctx.getStatus());
    }

    @Test
    void stateEntregueNaoCancela() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        ctx.entregar();
        ctx.cancelar();
        assertEquals("Entregue", ctx.getStatus());
    }

}