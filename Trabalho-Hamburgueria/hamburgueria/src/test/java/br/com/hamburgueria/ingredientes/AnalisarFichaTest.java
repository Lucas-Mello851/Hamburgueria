package br.com.hamburgueria.ingredientes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class AnalisarFichaTest {

    @Test
    void aplicaVisitante() {
        CatalogoIngredientes cat = new CatalogoIngredientes();
        FichaTecnica f = FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 1, 1, 1);
        ResumoFichaTextual r = cat.analisarFicha(f);
        assertNotNull(r);
        assertTrue(r.getTotalItens() > 0);
        assertNotNull(cat.getUltimoVisitante());
    }
}
