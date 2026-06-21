package br.com.hamburgueria.ingredientes;

import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesSmash;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesVegano;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FornecedorIngredientesTest {

    @Test
    void abstractFactoryClassicoPao() {
        assertTrue(new FornecedorIngredientesClassico().criarPao().getDescricao().contains("Brioche"));
    }

    @Test
    void abstractFactoryClassicoCarne() {
        assertTrue(new FornecedorIngredientesClassico().criarCarne().getDescricao().contains("Bovino"));
    }

    @Test
    void abstractFactoryClassicoMolho() {
        assertTrue(new FornecedorIngredientesClassico().criarMolho().getDescricao().contains("Maionese"));
    }

    @Test
    void abstractFactoryVeganoPao() {
        assertTrue(new FornecedorIngredientesVegano().criarPao().getDescricao().contains("Integral"));
    }

    @Test
    void abstractFactoryVeganoCarne() {
        assertTrue(new FornecedorIngredientesVegano().criarCarne().getDescricao().contains("Grao"));
    }

    @Test
    void abstractFactorySmashPao() {
        assertTrue(new FornecedorIngredientesSmash().criarPao().getDescricao().contains("Potato"));
    }

    @Test
    void abstractFactorySmashCarne() {
        assertTrue(new FornecedorIngredientesSmash().criarCarne().getDescricao().contains("Smash"));
    }

    @Test
    void abstractFactoryCarnePeso() {
        assertEquals(160.0, new FornecedorIngredientesClassico().criarCarne().getPeso());
    }

}