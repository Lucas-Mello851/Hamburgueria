package br.com.hamburgueria.ingredientes;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContadorIngredientesPorTipo implements VisitanteFicha {

    private final Map<String, Integer> porTipo = new LinkedHashMap<>();

    @Override
    public void visitarLinha(FichaTecnica.LinhaFicha linha) {
        String tipo = linha.getIngrediente().getTipo();
        porTipo.merge(tipo, linha.getQuantidade(), Integer::sum);
    }

    public Map<String, Integer> getContagemPorTipo() {
        return porTipo;
    }

    public int getQuantidadeDoTipo(String tipo) {
        return porTipo.getOrDefault(tipo, 0);
    }
}

