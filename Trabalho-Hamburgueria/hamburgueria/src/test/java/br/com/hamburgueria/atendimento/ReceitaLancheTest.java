package br.com.hamburgueria.atendimento;

import br.com.hamburgueria.atendimento.ReceitaClassico;
import br.com.hamburgueria.atendimento.ReceitaLanche;
import br.com.hamburgueria.atendimento.ReceitaVegano;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReceitaLancheTest {

    @Test
    @DisplayName("Template Method: preparo classico tem quatro etapas")
    void templateClassicoEtapas() {
        assertEquals(4, new ReceitaClassico().preparar().size());
    }

    @Test
    @DisplayName("Template Method: preparo classico comeca tostando o pao")
    void templateClassicoPrimeira() {
        assertTrue(new ReceitaClassico().preparar().get(0).toLowerCase().contains("pao"));
    }

    @Test
    @DisplayName("Template Method: preparo vegano usa embalagem sustentavel")
    void templateVeganoEmbalagem() {
        assertTrue(new ReceitaVegano().preparar().get(3).contains("sustentavel"));
    }

    @Test
    @DisplayName("Template Method: subclasse e um ReceitaLanche")
    void templateHeranca() {
        assertInstanceOf(ReceitaLanche.class, new ReceitaClassico());
    }

}