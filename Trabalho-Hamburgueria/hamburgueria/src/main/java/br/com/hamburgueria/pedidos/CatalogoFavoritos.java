package br.com.hamburgueria.pedidos;

import java.util.HashMap;
import java.util.Map;

public class CatalogoFavoritos {

    private final Map<String, PedidoFavorito> favoritos = new HashMap<>();

    public void salvar(String nome, PedidoFavorito pedido) {
        favoritos.put(nome, pedido);
    }

    public PedidoFavorito clonar(String nome) {
        PedidoFavorito favorito = favoritos.get(nome);
        if (favorito == null) {
            throw new IllegalArgumentException("Favorito nao encontrado: " + nome);
        }
        return favorito.clone();
    }

    public boolean contemFavorito(String nome) {
        return favoritos.containsKey(nome);
    }

    public int getTotalFavoritos() {
        return favoritos.size();
    }
}
