package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.pedidos.CatalogoFavoritos;
import br.com.hamburgueria.pedidos.PedidoFavorito;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FavoritoTest {

    @Test
    void prototypeCloneDiferente() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        assertNotSame(original, original.clone());
    }

    @Test
    void prototypeCloneTipo() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        assertEquals("Smash", original.clone().getTipoLanche());
    }

    @Test
    void prototypeCloneAdicionais() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo", "Bacon"), "");
        assertEquals(List.of("Queijo", "Bacon"), original.clone().getAdicionais());
    }

    @Test
    void prototypeCloneIndependente() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        original.clone().adicionarAdicional("Bacon");
        assertFalse(original.getAdicionais().contains("Bacon"));
    }

    @Test
    void prototypeRegistroClona() {
        CatalogoFavoritos registro = new CatalogoFavoritos();
        registro.salvar("fav", new PedidoFavorito("Vegano", List.of(), ""));
        assertEquals("Vegano", registro.clonar("fav").getTipoLanche());
    }

    @Test
    void prototypeRegistroContem() {
        CatalogoFavoritos registro = new CatalogoFavoritos();
        registro.salvar("fav", new PedidoFavorito("Classico", List.of(), ""));
        assertTrue(registro.contemFavorito("fav"));
    }

    @Test
    void prototypeFavoritoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> new CatalogoFavoritos().clonar("nao existe"));
    }

}