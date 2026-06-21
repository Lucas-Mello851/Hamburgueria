package br.com.hamburgueria.ingredientes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoIngredientesTest {

    private final CatalogoIngredientes cat = new CatalogoIngredientes();

    @Test
    void quantidades() {
        assertEquals(3, cat.getPaes().size());
        assertEquals(3, cat.getCarnes().size());
        assertEquals(3, cat.getMolhos().size());
    }

    @Test
    void total() { assertEquals(9, cat.getTotalIngredientes()); }

    @Test
    void descricoes() { assertEquals(9, cat.listarDescricoes().size()); }

    @Test
    void peso() { assertTrue(cat.pesoTotalCarnes() > 0); }

    @Test
    void compartilhados() {
        CatalogoIngredientes c = new CatalogoIngredientes();
        assertEquals(9, c.compartilhados().size());
    }

    @Test
    void cache() {
        CatalogoIngredientes c = new CatalogoIngredientes();
        assertTrue(c.totalCompartilhadosEmCache() > 0);
    }
}
