package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.produtos.Lanche;


import java.util.ArrayList;
import java.util.List;

public class RegistroMontagem {

    private final String tipoLanche;
    private final List<String> adicionais;
    private final String observacao;

    public RegistroMontagem(String tipoLanche, List<String> adicionais, String observacao) {
        this.tipoLanche = tipoLanche;
        this.adicionais = new ArrayList<>(adicionais);
        this.observacao = observacao;
    }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return new ArrayList<>(adicionais); }
    public String getObservacao() { return observacao; }

    @Override
    public String toString() {
        return "Lanche=" + tipoLanche + ", Adicionais=" + adicionais + ", Obs='" + observacao + "'";
    }
}
