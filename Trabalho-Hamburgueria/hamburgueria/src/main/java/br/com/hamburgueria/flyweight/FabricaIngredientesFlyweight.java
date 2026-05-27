package br.com.hamburgueria.flyweight;

import br.com.hamburgueria.abstractfactory.Carne;
import br.com.hamburgueria.abstractfactory.Molho;
import br.com.hamburgueria.abstractfactory.Pao;

import java.util.HashMap;
import java.util.Map;

public class FabricaIngredientesFlyweight {

    private static final Map<String, IngredienteFlyweight> cache = new HashMap<>();

    private FabricaIngredientesFlyweight() {}

    public static IngredienteFlyweight getPao(Pao pao) {
        String chave = "PAO_" + pao.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteFlyweightImpl(pao.getDescricao(), "Pao"));
    }

    public static IngredienteFlyweight getCarne(Carne carne) {
        String chave = "CARNE_" + carne.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteFlyweightImpl(carne.getDescricao(), "Carne"));
    }

    public static IngredienteFlyweight getMolho(Molho molho) {
        String chave = "MOLHO_" + molho.getDescricao();
        return cache.computeIfAbsent(chave, k -> new IngredienteFlyweightImpl(molho.getDescricao(), "Molho"));
    }

    public static int getTotalCacheado() {
        return cache.size();
    }

    public static void exibirCache() {
        System.out.println("Cache Flyweight (" + cache.size() + " instancias):");
        cache.forEach((k, v) -> System.out.println("  " + k + " -> " + v.getDescricao()));
    }
}
