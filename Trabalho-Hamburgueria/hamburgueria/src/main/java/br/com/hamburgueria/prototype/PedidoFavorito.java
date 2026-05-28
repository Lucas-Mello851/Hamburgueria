package br.com.hamburgueria.prototype;

import java.util.ArrayList;
import java.util.List;

public class PedidoFavorito implements Cloneable {

    private String tipoLanche;
    private List<String> adicionais;
    private String observacao;

    public PedidoFavorito(String tipoLanche, List<String> adicionais, String observacao) {
        this.tipoLanche = tipoLanche;
        this.adicionais = new ArrayList<>(adicionais);
        this.observacao = observacao;
    }

    @Override
    public PedidoFavorito clone() {
        try {
            PedidoFavorito copia = (PedidoFavorito) super.clone();
            copia.adicionais = new ArrayList<>(this.adicionais);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarAdicional(String adicional) {
        adicionais.add(adicional);
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setTipoLanche(String tipoLanche) {
        this.tipoLanche = tipoLanche;
    }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return new ArrayList<>(adicionais); }
    public String getObservacao() { return observacao; }

    @Override
    public String toString() {
        return "PedidoFavorito{tipo=" + tipoLanche + ", adicionais=" + adicionais + ", obs='" + observacao + "'}";
    }
}
