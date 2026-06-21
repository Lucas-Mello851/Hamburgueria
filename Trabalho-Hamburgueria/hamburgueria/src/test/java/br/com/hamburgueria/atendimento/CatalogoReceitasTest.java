package br.com.hamburgueria.atendimento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoReceitasTest {

    private final CatalogoReceitas cat = new CatalogoReceitas();

    @Test
    void classico() { assertFalse(cat.etapasDe("CLASSICO").isEmpty()); }

    @Test
    void smash() { assertInstanceOf(ReceitaSmash.class, cat.obter("SMASH")); }

    @Test
    void vegano() { assertInstanceOf(ReceitaVegano.class, cat.obter("VEGANO")); }

    @Test
    void fallback() { assertInstanceOf(ReceitaClassico.class, cat.obter("XPTO")); }

    @Test
    void total() { assertEquals(3, cat.getTotalReceitas()); }
}
