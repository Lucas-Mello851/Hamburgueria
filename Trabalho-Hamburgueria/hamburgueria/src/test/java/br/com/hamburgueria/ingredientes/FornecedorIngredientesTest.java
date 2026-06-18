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
    @DisplayName("Abstract Factory: classica cria pao brioche")
    void abstractFactoryClassicoPao() {
        assertTrue(new FornecedorIngredientesClassico().criarPao().getDescricao().contains("Brioche"));
    }

    @Test
    @DisplayName("Abstract Factory: classica cria carne bovina")
    void abstractFactoryClassicoCarne() {
        assertTrue(new FornecedorIngredientesClassico().criarCarne().getDescricao().contains("Bovino"));
    }

    @Test
    @DisplayName("Abstract Factory: classica cria maionese")
    void abstractFactoryClassicoMolho() {
        assertTrue(new FornecedorIngredientesClassico().criarMolho().getDescricao().contains("Maionese"));
    }

    @Test
    @DisplayName("Abstract Factory: vegana cria pao integral")
    void abstractFactoryVeganoPao() {
        assertTrue(new FornecedorIngredientesVegano().criarPao().getDescricao().contains("Integral"));
    }

    @Test
    @DisplayName("Abstract Factory: vegana cria blend de grao de bico")
    void abstractFactoryVeganoCarne() {
        assertTrue(new FornecedorIngredientesVegano().criarCarne().getDescricao().contains("Grao"));
    }

    @Test
    @DisplayName("Abstract Factory: smash cria pao potato")
    void abstractFactorySmashPao() {
        assertTrue(new FornecedorIngredientesSmash().criarPao().getDescricao().contains("Potato"));
    }

    @Test
    @DisplayName("Abstract Factory: smash cria carne smash")
    void abstractFactorySmashCarne() {
        assertTrue(new FornecedorIngredientesSmash().criarCarne().getDescricao().contains("Smash"));
    }

    @Test
    @DisplayName("Abstract Factory: carne classica tem peso definido")
    void abstractFactoryCarnePeso() {
        assertEquals(160.0, new FornecedorIngredientesClassico().criarCarne().getPeso());
    }

}