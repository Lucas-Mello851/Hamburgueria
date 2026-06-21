package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.OperacaoRegistrarPedido;
import br.com.hamburgueria.atendimento.OperadorCaixa;
import br.com.hamburgueria.pedidos.CicloPedido;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OperadorCaixaTest {

    @Test
    void commandRegistrar() {
        CicloPedido ctx = new CicloPedido();
        new OperadorCaixa().executar(new OperacaoRegistrarPedido("Smash", ctx));
        assertEquals("Em preparo", ctx.getStatus());
    }

    @Test
    void commandTotalOperacoes() {
        OperadorCaixa operador = new OperadorCaixa();
        operador.executar(new OperacaoRegistrarPedido("Smash", new CicloPedido()));
        assertEquals(1, operador.getTotalOperacoes());
    }

    @Test
    void commandDesfazer() {
        CicloPedido ctx = new CicloPedido();
        OperadorCaixa operador = new OperadorCaixa();
        operador.executar(new OperacaoRegistrarPedido("Classico", ctx));
        operador.desfazerUltimo();
        assertEquals("Cancelado", ctx.getStatus());
    }

    @Test
    void commandDesfazerVazio() {
        assertFalse(new OperadorCaixa().desfazerUltimo());
    }

}