package br.com.hamburgueria.pedidos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class RegistroMontagemTest {

    @Test
    void guardaEstado() {
        RegistroMontagem r = new RegistroMontagem("Smash", Arrays.asList("Queijo"), "sem cebola");
        assertEquals("Smash", r.getTipoLanche());
        assertTrue(r.getAdicionais().contains("Queijo"));
        assertEquals("sem cebola", r.getObservacao());
    }

    @Test
    void copiaDefensiva() {
        RegistroMontagem r = new RegistroMontagem("Classico", Arrays.asList("Bacon"), "");
        r.getAdicionais().clear();
        assertTrue(r.getAdicionais().contains("Bacon"));
    }

    @Test
    void toStringTipo() {
        RegistroMontagem r = new RegistroMontagem("Vegano", Arrays.asList(), "");
        assertTrue(r.toString().contains("Vegano"));
    }
}
