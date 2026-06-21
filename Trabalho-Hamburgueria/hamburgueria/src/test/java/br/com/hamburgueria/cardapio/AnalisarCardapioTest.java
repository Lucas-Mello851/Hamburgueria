package br.com.hamburgueria.cardapio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class AnalisarCardapioTest {

    @Test
    void aplicaAnalisador() {
        CardapioComCombos c = CardapioComCombos.getInstance();
        AnalisadorResumo r = new AnalisadorResumo();
        c.analisar(r);
        assertSame(r, c.getUltimoAnalisador());
    }
}
