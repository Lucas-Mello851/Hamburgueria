package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.EtapaValidacao;
import br.com.hamburgueria.atendimento.FinalizacaoPedido;
import br.com.hamburgueria.atendimento.SolicitacaoPedido;
import br.com.hamburgueria.atendimento.ValidacaoEstoque;
import br.com.hamburgueria.atendimento.ValidacaoPagamento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValidacaoPedidoTest {

    @Test
    void chainValido() {
        EtapaValidacao cadeia = new ValidacaoEstoque();
        cadeia.setProximo(new ValidacaoPagamento()).setProximo(new FinalizacaoPedido());
        SolicitacaoPedido s = new SolicitacaoPedido("Smash", 35.0);
        cadeia.processar(s);
        assertTrue(s.isProcessado());
    }

    @Test
    void chainInvalido() {
        EtapaValidacao cadeia = new ValidacaoEstoque();
        cadeia.setProximo(new ValidacaoPagamento()).setProximo(new FinalizacaoPedido());
        SolicitacaoPedido s = new SolicitacaoPedido("Classico", 0.0);
        cadeia.processar(s);
        assertFalse(s.isProcessado());
    }

    @Test
    void chainSolicitacaoTipo() {
        assertEquals("Vegano", new SolicitacaoPedido("Vegano", 26.0).getTipo());
    }

    @Test
    void chainSolicitacaoValor() {
        assertEquals(26.0, new SolicitacaoPedido("Vegano", 26.0).getValor());
    }

    @Test
    void chainEstoqueTipoDesconhecido() {
        EtapaValidacao cadeia = new ValidacaoEstoque();
        cadeia.setProximo(new ValidacaoPagamento()).setProximo(new FinalizacaoPedido());
        SolicitacaoPedido s = new SolicitacaoPedido("Inexistente", 30.0);
        cadeia.processar(s);
        assertFalse(s.isProcessado());
    }

    @Test
    void chainSolicitacaoInicial() {
        assertFalse(new SolicitacaoPedido("Vegano", 26.0).isProcessado());
    }

}