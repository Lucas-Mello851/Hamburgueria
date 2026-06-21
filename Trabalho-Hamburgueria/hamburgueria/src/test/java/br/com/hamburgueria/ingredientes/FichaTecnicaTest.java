package br.com.hamburgueria.ingredientes;

import br.com.hamburgueria.cardapio.Cardapio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FichaTecnicaTest {

    @Test
    void fichaCompartilhaIngredientes() {
        Cardapio cardapio = Cardapio.getInstance();
        FichaTecnica f1 = FichaTecnica.montar("Clássico", cardapio.getFornecedorIngredientes("Clássico"), 1, 1, 1);
        FichaTecnica f2 = FichaTecnica.montar("Clássico", cardapio.getFornecedorIngredientes("Clássico"), 2, 2, 2);
        assertSame(f1.getLinhas().get(0).getIngrediente(), f2.getLinhas().get(0).getIngrediente());
    }

    @Test
    void fichaQuantidadeExtrinseca() {
        Cardapio cardapio = Cardapio.getInstance();
        FichaTecnica ficha = FichaTecnica.montar("Smash", cardapio.getFornecedorIngredientes("Smash"), 1, 2, 1);
        assertEquals(2, ficha.getLinhas().get(1).getQuantidade());
    }

    @Test
    void fichaTotalIngredientes() {
        Cardapio cardapio = Cardapio.getInstance();
        FichaTecnica ficha = FichaTecnica.montar("Vegano", cardapio.getFornecedorIngredientes("Vegano"), 1, 1, 1);
        assertEquals(3, ficha.getTotalIngredientes());
    }

    @Test
    void fichaNomeLanche() {
        Cardapio cardapio = Cardapio.getInstance();
        FichaTecnica ficha = FichaTecnica.montar("Smash", cardapio.getFornecedorIngredientes("Smash"), 1, 1, 1);
        assertEquals("Smash", ficha.getNomeLanche());
    }

}

