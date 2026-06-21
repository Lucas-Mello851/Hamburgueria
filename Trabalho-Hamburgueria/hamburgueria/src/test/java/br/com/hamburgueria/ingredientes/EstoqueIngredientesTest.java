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
    void flyweightMesmaInstancia() {
        FornecedorIngredientes fabrica = new FornecedorIngredientesClassico();
        IngredienteCompartilhado pao1 = EstoqueIngredientes.getPao(fabrica.criarPao());
        IngredienteCompartilhado pao2 = EstoqueIngredientes.getPao(fabrica.criarPao());
        assertSame(pao1, pao2);
    }

    @Test
    void flyweightInstanciasDiferentes() {
        IngredienteCompartilhado classico = EstoqueIngredientes.getPao(new FornecedorIngredientesClassico().criarPao());
        IngredienteCompartilhado smash = EstoqueIngredientes.getPao(new FornecedorIngredientesSmash().criarPao());
        assertNotSame(classico, smash);
    }

    @Test
    void flyweightDescricao() {
        IngredienteCompartilhado carne = EstoqueIngredientes.getCarne(new FornecedorIngredientesClassico().criarCarne());
        assertEquals("Blend Bovino 160g", carne.getDescricao());
    }

    @Test
    void flyweightTipo() {
        IngredienteCompartilhado molho = EstoqueIngredientes.getMolho(new FornecedorIngredientesClassico().criarMolho());
        assertEquals("Molho", molho.getTipo());
    }

}