package br.com.hamburgueria.pagamento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class InterpretadorCupomTest {

    private final InterpretadorCupom interp = new InterpretadorCupom();

    @Test
    void cupomEstudante() {
        assertInstanceOf(DescontoEstudante.class, interp.interpretar("ESTUDANTE"));
    }

    @Test
    void cupomFidelidade() {
        assertInstanceOf(DescontoFidelidade.class, interp.interpretar("fidelidade"));
    }

    @Test
    void cupomPromocional() {
        PoliticaDesconto d = interp.interpretar("PROMO20");
        assertInstanceOf(DescontoPromocao.class, d);
        assertEquals(80.0, d.calcular(100.0), 0.0001);
    }

    @Test
    void cupomDesconhecido() {
        PoliticaDesconto d = interp.interpretar("XPTO");
        assertInstanceOf(DescontoPadrao.class, d);
        assertEquals(100.0, d.calcular(100.0), 0.0001);
    }

    @Test
    void cupomNulo() {
        assertInstanceOf(DescontoPadrao.class, interp.interpretar(null));
    }
}

