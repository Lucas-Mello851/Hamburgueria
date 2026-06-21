package br.com.hamburgueria.cardapio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PrecosTest {

    @Test
    void precosLanches() {
        assertTrue(Precos.HAMBURGUER_CLASSICO > 0);
        assertTrue(Precos.HAMBURGUER_VEGANO > 0);
        assertTrue(Precos.HAMBURGUER_SMASH > 0);
    }

    @Test
    void fatoresDesconto() {
        assertTrue(Precos.FATOR_DESCONTO_ESTUDANTE > 0 && Precos.FATOR_DESCONTO_ESTUDANTE < 1);
        assertTrue(Precos.FATOR_DESCONTO_FIDELIDADE > 0 && Precos.FATOR_DESCONTO_FIDELIDADE < 1);
    }

    @Test
    void classeCarrega() {
        assertNotNull(Precos.class);
    }
}
