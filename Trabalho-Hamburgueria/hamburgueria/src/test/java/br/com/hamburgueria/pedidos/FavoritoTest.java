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
    @DisplayName("Prototype: clone e instancia diferente do original")
    void prototypeCloneDiferente() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        assertNotSame(original, original.clone());
    }

    @Test
    @DisplayName("Prototype: clone mantem o tipo do lanche")
    void prototypeCloneTipo() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        assertEquals("Smash", original.clone().getTipoLanche());
    }

    @Test
    @DisplayName("Prototype: clone mantem os adicionais")
    void prototypeCloneAdicionais() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo", "Bacon"), "");
        assertEquals(List.of("Queijo", "Bacon"), original.clone().getAdicionais());
    }

    @Test
    @DisplayName("Prototype: alterar clone nao afeta original")
    void prototypeCloneIndependente() {
        PedidoFavorito original = new PedidoFavorito("Smash", List.of("Queijo"), "sem cebola");
        original.clone().adicionarAdicional("Bacon");
        assertFalse(original.getAdicionais().contains("Bacon"));
    }

    @Test
    @DisplayName("Prototype: registro clona favorito salvo")
    void prototypeRegistroClona() {
        CatalogoFavoritos registro = new CatalogoFavoritos();
        registro.salvar("fav", new PedidoFavorito("Vegano", List.of(), ""));
        assertEquals("Vegano", registro.clonar("fav").getTipoLanche());
    }

    @Test
    @DisplayName("Prototype: registro confirma favorito salvo")
    void prototypeRegistroContem() {
        CatalogoFavoritos registro = new CatalogoFavoritos();
        registro.salvar("fav", new PedidoFavorito("Classico", List.of(), ""));
        assertTrue(registro.contemFavorito("fav"));
    }

    @Test
    @DisplayName("Prototype: favorito inexistente lanca excecao")
    void prototypeFavoritoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> new CatalogoFavoritos().clonar("nao existe"));
    }

}