package br.com.hamburgueria.atendimento;

import java.util.ArrayList;
import java.util.List;

public abstract class ReceitaLanche {

    public final List<String> preparar() {
        List<String> etapas = new ArrayList<>();
        etapas.add(tostarPao());
        etapas.add(prepararCarne());
        etapas.add(montarIngredientes());
        etapas.add(embalar());
        return etapas;
    }

    protected String tostarPao() {
        return "Tostar o pao na chapa";
    }

    protected abstract String prepararCarne();

    protected abstract String montarIngredientes();

    protected String embalar() {
        return "Embalar o lanche";
    }
}
