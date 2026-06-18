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
    @DisplayName("Command: registrar pedido muda estado para em preparo")
    void commandRegistrar() {
        CicloPedido ctx = new CicloPedido();
        new OperadorCaixa().executar(new OperacaoRegistrarPedido("Smash", ctx));
        assertEquals("Em preparo", ctx.getStatus());
    }

    @Test
    @DisplayName("Command: executar incrementa o total de operacoes")
    void commandTotalOperacoes() {
        OperadorCaixa operador = new OperadorCaixa();
        operador.executar(new OperacaoRegistrarPedido("Smash", new CicloPedido()));
        assertEquals(1, operador.getTotalOperacoes());
    }

    @Test
    @DisplayName("Command: desfazer cancela o pedido registrado")
    void commandDesfazer() {
        CicloPedido ctx = new CicloPedido();
        OperadorCaixa operador = new OperadorCaixa();
        operador.executar(new OperacaoRegistrarPedido("Classico", ctx));
        operador.desfazerUltimo();
        assertEquals("Cancelado", ctx.getStatus());
    }

    @Test
    @DisplayName("Command: desfazer sem operacoes retorna falso")
    void commandDesfazerVazio() {
        assertFalse(new OperadorCaixa().desfazerUltimo());
    }

}