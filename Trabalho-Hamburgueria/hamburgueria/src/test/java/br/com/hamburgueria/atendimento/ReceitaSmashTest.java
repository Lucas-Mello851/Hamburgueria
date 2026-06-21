package br.com.hamburgueria.atendimento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReceitaSmashTest {

    @Test
    void quatroEtapas() {
        List<String> etapas = new ReceitaSmash().preparar();
        assertEquals(4, etapas.size());
    }

    @Test
    void carneSmash() {
        List<String> etapas = new ReceitaSmash().preparar();
        assertTrue(etapas.get(1).contains("Smashar"));
    }

    @Test
    void montagemPotato() {
        List<String> etapas = new ReceitaSmash().preparar();
        assertTrue(etapas.get(2).contains("potato"));
    }
}
