package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoEstudante;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pedidos.CicloPedido;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class OperacoesCaixaTest {

    @Test
    void aplicarExecutar() {
        CalculadoraDesconto calc = new CalculadoraDesconto(new DescontoPadrao());
        OperacaoAplicarDesconto op = new OperacaoAplicarDesconto(calc, new DescontoEstudante());
        op.executar();
        assertTrue(calc.calcularPrecoFinal(100.0) < 100.0);
    }

    @Test
    void aplicarDesfazer() {
        CalculadoraDesconto calc = new CalculadoraDesconto(new DescontoPadrao());
        OperacaoAplicarDesconto op = new OperacaoAplicarDesconto(calc, new DescontoEstudante());
        op.executar();
        op.desfazer();
        assertEquals(100.0, calc.calcularPrecoFinal(100.0), 0.0001);
    }

    @Test
    void cancelarExecutar() {
        CicloPedido ciclo = new CicloPedido();
        OperacaoCancelarPedido op = new OperacaoCancelarPedido(ciclo);
        op.executar();
        assertEquals("Cancelado", ciclo.getStatus());
    }

    @Test
    void cancelarDesfazer() {
        CicloPedido ciclo = new CicloPedido();
        OperacaoCancelarPedido op = new OperacaoCancelarPedido(ciclo);
        op.executar();
        op.desfazer();
        assertEquals("Cancelado", ciclo.getStatus());
    }

    @Test
    void operadorPilha() {
        CicloPedido ciclo = new CicloPedido();
        OperadorCaixa caixa = new OperadorCaixa();
        caixa.executar(new OperacaoCancelarPedido(ciclo));
        assertEquals(1, caixa.getTotalOperacoes());
        assertTrue(caixa.desfazerUltimo());
        assertEquals(0, caixa.getTotalOperacoes());
    }

    @Test
    void operadorVazio() {
        assertFalse(new OperadorCaixa().desfazerUltimo());
    }
}
