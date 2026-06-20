package br.com.hamburgueria.atendimento;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CatalogoReceitas {

    private final Map<String, ReceitaLanche> receitas = new LinkedHashMap<>();

    public CatalogoReceitas() {
        receitas.put("CLASSICO", new ReceitaClassico());
        receitas.put("SMASH", new ReceitaSmash());
        receitas.put("VEGANO", new ReceitaVegano());
    }

    public ReceitaLanche obter(String tipo) {
        ReceitaLanche receita = receitas.get(tipo == null ? "" : tipo.trim().toUpperCase());
        if (receita == null) {
            receita = receitas.get("CLASSICO");
        }
        return receita;
    }

    public List<String> etapasDe(String tipo) {
        return obter(tipo).preparar();
    }

    public int getTotalReceitas() {
        return receitas.size();
    }
}
