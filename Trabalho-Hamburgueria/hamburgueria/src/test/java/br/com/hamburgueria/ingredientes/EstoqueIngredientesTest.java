package br.com.hamburgueria.ingredientes;

import br.com.hamburgueria.ingredientes.EstoqueIngredientes;
import br.com.hamburgueria.ingredientes.FornecedorIngredientes;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesSmash;
import br.com.hamburgueria.ingredientes.IngredienteCompartilhado;
import br.com.hamburgueria.ingredientes.Molho;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueIngredientesTest {

    @Test
    @DisplayName("Flyweight: mesma chave retorna a mesma instancia")
    void flyweightMesmaInstancia() {
        FornecedorIngredientes fabrica = new FornecedorIngredientesClassico();
        IngredienteCompartilhado pao1 = EstoqueIngredientes.getPao(fabrica.criarPao());
        IngredienteCompartilhado pao2 = EstoqueIngredientes.getPao(fabrica.criarPao());
        assertSame(pao1, pao2);
    }

    @Test
    @DisplayName("Flyweight: paes diferentes geram instancias diferentes")
    void flyweightInstanciasDiferentes() {
        IngredienteCompartilhado classico = EstoqueIngredientes.getPao(new FornecedorIngredientesClassico().criarPao());
        IngredienteCompartilhado smash = EstoqueIngredientes.getPao(new FornecedorIngredientesSmash().criarPao());
        assertNotSame(classico, smash);
    }

    @Test
    @DisplayName("Flyweight: descricao do ingrediente esta correta")
    void flyweightDescricao() {
        IngredienteCompartilhado carne = EstoqueIngredientes.getCarne(new FornecedorIngredientesClassico().criarCarne());
        assertEquals("Blend Bovino 160g", carne.getDescricao());
    }

    @Test
    @DisplayName("Flyweight: tipo do ingrediente esta correto")
    void flyweightTipo() {
        IngredienteCompartilhado molho = EstoqueIngredientes.getMolho(new FornecedorIngredientesClassico().criarMolho());
        assertEquals("Molho", molho.getTipo());
    }

}