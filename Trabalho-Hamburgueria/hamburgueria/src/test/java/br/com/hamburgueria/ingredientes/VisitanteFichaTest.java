package br.com.hamburgueria.ingredientes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class VisitanteFichaTest {

    private FichaTecnica ficha() {
        return FichaTecnica.montar("Classico", new FornecedorIngredientesClassico(), 2, 1, 3);
    }

    @Test
    void contaPorTipo() {
        ContadorIngredientesPorTipo contador = new ContadorIngredientesPorTipo();
        ficha().aceitar(contador);

        assertEquals(2, contador.getQuantidadeDoTipo("Pao"));
        assertEquals(1, contador.getQuantidadeDoTipo("Carne"));
        assertEquals(3, contador.getQuantidadeDoTipo("Molho"));
    }

    @Test
    void resumoTotal() {
        ResumoFichaTextual resumo = new ResumoFichaTextual();
        ficha().aceitar(resumo);
        assertEquals(6, resumo.getTotalItens());
        assertFalse(resumo.getTexto().isEmpty());
    }

    @Test
    void doisVisitantes() {
        FichaTecnica f = ficha();
        ContadorIngredientesPorTipo c = new ContadorIngredientesPorTipo();
        ResumoFichaTextual r = new ResumoFichaTextual();
        f.aceitar(c);
        f.aceitar(r);
        assertEquals(r.getTotalItens(),
                c.getQuantidadeDoTipo("Pao") + c.getQuantidadeDoTipo("Carne") + c.getQuantidadeDoTipo("Molho"));
    }
}

