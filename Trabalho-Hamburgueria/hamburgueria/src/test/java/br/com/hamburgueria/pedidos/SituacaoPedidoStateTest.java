package br.com.hamburgueria.pedidos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class SituacaoPedidoStateTest {

    private CicloPedido ciclo() { return new CicloPedido(); }

    @Test
    void aguardandoStatus() {
        assertEquals("Aguardando confirmacao", ciclo().getStatus());
    }

    @Test
    void aguardandoConfirma() {
        CicloPedido c = ciclo(); c.confirmar();
        assertEquals("Em preparo", c.getStatus());
    }

    @Test
    void aguardandoCancela() {
        CicloPedido c = ciclo(); c.cancelar();
        assertEquals("Cancelado", c.getStatus());
    }

    @Test
    void aguardandoPreparaNoop() {
        CicloPedido c = ciclo(); c.preparar();
        assertEquals("Aguardando confirmacao", c.getStatus());
    }

    @Test
    void aguardandoEntregaNoop() {
        CicloPedido c = ciclo(); c.entregar();
        assertEquals("Aguardando confirmacao", c.getStatus());
    }

    @Test
    void emPreparoPrepara() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar();
        assertEquals("Pronto", c.getStatus());
    }

    @Test
    void emPreparoCancela() {
        CicloPedido c = ciclo(); c.confirmar(); c.cancelar();
        assertEquals("Cancelado", c.getStatus());
    }

    @Test
    void emPreparoConfirmaNoop() {
        CicloPedido c = ciclo(); c.confirmar(); c.confirmar();
        assertEquals("Em preparo", c.getStatus());
    }

    @Test
    void emPreparoEntregaNoop() {
        CicloPedido c = ciclo(); c.confirmar(); c.entregar();
        assertEquals("Em preparo", c.getStatus());
    }

    @Test
    void prontoEntrega() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar(); c.entregar();
        assertEquals("Entregue", c.getStatus());
    }

    @Test
    void prontoConfirmaNoop() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar(); c.confirmar();
        assertEquals("Pronto", c.getStatus());
    }

    @Test
    void prontoPreparaNoop() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar(); c.preparar();
        assertEquals("Pronto", c.getStatus());
    }

    @Test
    void prontoCancelaNoop() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar(); c.cancelar();
        assertEquals("Pronto", c.getStatus());
    }

    @Test
    void entregueTerminal() {
        CicloPedido c = ciclo(); c.confirmar(); c.preparar(); c.entregar();
        c.confirmar(); c.preparar(); c.entregar(); c.cancelar();
        assertEquals("Entregue", c.getStatus());
    }

    @Test
    void canceladoTerminal() {
        CicloPedido c = ciclo(); c.cancelar();
        c.confirmar(); c.preparar(); c.entregar(); c.cancelar();
        assertEquals("Cancelado", c.getStatus());
    }
}
