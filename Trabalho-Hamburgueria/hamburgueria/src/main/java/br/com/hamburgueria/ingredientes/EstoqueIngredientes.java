package br.com.hamburgueria.ingredientes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueIngredientes {

    private static final Map<String, IngredienteCompartilhado> cache = new HashMap<>();

    private EstoqueIngredientes() {}

    public static IngredienteCompartilhado getPao(Pao pao) {
        String chave = "PAO_" + pao.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteCompartilhadoImpl(pao.getDescricao(), "Pao"));
    }

    public static IngredienteCompartilhado getCarne(Carne carne) {
        String chave = "CARNE_" + carne.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteCompartilhadoImpl(carne.getDescricao(), "Carne"));
    }

    public static IngredienteCompartilhado getMolho(Molho molho) {
        String chave = "MOLHO_" + molho.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteCompartilhadoImpl(molho.getDescricao(), "Molho"));
    }

    public static int getTotalCacheado() {
        return cache.size();
    }

    public static List<String> getChavesCache() {
        return new ArrayList<>(cache.keySet());
    }
}
