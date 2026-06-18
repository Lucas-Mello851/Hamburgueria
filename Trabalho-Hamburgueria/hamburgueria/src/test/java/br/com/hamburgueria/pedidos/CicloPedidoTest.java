package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.CicloPedido;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CicloPedidoTest {

    @Test
    @DisplayName("State: estado inicial e aguardando")
    void stateInicial() {
        assertEquals("Aguardando confirmacao", new CicloPedido().getStatus());
    }

    @Test
    @DisplayName("State: confirmar muda para em preparo")
    void stateConfirmar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        assertEquals("Em preparo", ctx.getStatus());
    }

    @Test
    @DisplayName("State: preparar muda para pronto")
    void statePreparar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        assertEquals("Pronto", ctx.getStatus());
    }

    @Test
    @DisplayName("State: entregar muda para entregue")
    void stateEntregar() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        ctx.entregar();
        assertEquals("Entregue", ctx.getStatus());
    }

    @Test
    @DisplayName("State: cancelar no inicio muda para cancelado")
    void stateCancelar() {
        CicloPedido ctx = new CicloPedido();
        ctx.cancelar();
        assertEquals("Cancelado", ctx.getStatus());
    }

    @Test
    @DisplayName("State: entregar sem confirmar nao avanca")
    void stateEntregarSemConfirmar() {
        CicloPedido ctx = new CicloPedido();
        ctx.entregar();
        assertEquals("Aguardando confirmacao", ctx.getStatus());
    }

    @Test
    @DisplayName("State: pedido entregue nao pode ser cancelado")
    void stateEntregueNaoCancela() {
        CicloPedido ctx = new CicloPedido();
        ctx.confirmar();
        ctx.preparar();
        ctx.entregar();
        ctx.cancelar();
        assertEquals("Entregue", ctx.getStatus());
    }

}