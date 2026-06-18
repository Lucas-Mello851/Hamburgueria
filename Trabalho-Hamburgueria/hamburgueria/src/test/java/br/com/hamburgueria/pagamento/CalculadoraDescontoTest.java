package br.com.hamburgueria.pagamento;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.pagamento.CalculadoraDesconto;
import br.com.hamburgueria.pagamento.DescontoEstudante;
import br.com.hamburgueria.pagamento.DescontoFidelidade;
import br.com.hamburgueria.pagamento.DescontoPadrao;
import br.com.hamburgueria.pagamento.DescontoPromocao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTest {

    @Test
    @DisplayName("Strategy: sem desconto mantem o preco")
    void strategySemDesconto() {
        assertEquals(35.0, new CalculadoraDesconto(new DescontoPadrao()).calcularPrecoFinal(35.0));
    }

    @Test
    @DisplayName("Strategy: desconto estudante aplica 15 por cento")
    void strategyEstudante() {
        assertEquals(35.0 * Precos.FATOR_DESCONTO_ESTUDANTE, new CalculadoraDesconto(new DescontoEstudante()).calcularPrecoFinal(35.0));
    }

    @Test
    @DisplayName("Strategy: desconto fidelidade aplica 10 por cento")
    void strategyFidelidade() {
        assertEquals(35.0 * Precos.FATOR_DESCONTO_FIDELIDADE, new CalculadoraDesconto(new DescontoFidelidade()).calcularPrecoFinal(35.0));
    }

    @Test
    @DisplayName("Strategy: desconto promocao aplica o percentual informado")
    void strategyPromocao() {
        assertEquals(28.0, new CalculadoraDesconto(new DescontoPromocao(20)).calcularPrecoFinal(35.0));
    }

    @Test
    @DisplayName("Strategy: trocar estrategia muda o calculo")
    void strategyTroca() {
        CalculadoraDesconto calc = new CalculadoraDesconto(new DescontoPadrao());
        calc.setStrategy(new DescontoEstudante());
        assertEquals(35.0 * Precos.FATOR_DESCONTO_ESTUDANTE, calc.calcularPrecoFinal(35.0));
    }

    @Test
    @DisplayName("Strategy: descricao do desconto estudante")
    void strategyDescricao() {
        assertTrue(new CalculadoraDesconto(new DescontoEstudante()).getDescricaoDesconto().toLowerCase().contains("estudante"));
    }

}