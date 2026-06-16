package Classes;

import java.util.ArrayList;
import java.util.List;

public class ContextoPedidoTexto {

    private String entrada;
    private String tipoLanche;
    private List<String> adicionais;
    private List<String> remocoes;

    public ContextoPedidoTexto(String entrada) {
        this.entrada = entrada.toLowerCase();
        this.adicionais = new ArrayList<>();
        this.remocoes = new ArrayList<>();
    }

    public String getEntrada() {
        return entrada;
    }

    public void setTipoLanche(String tipo) {
        this.tipoLanche = tipo;
    }

    public void adicionarIngrediente(String ingrediente) {
        adicionais.add(ingrediente);
    }

    public void removerIngrediente(String ingrediente) {
        remocoes.add(ingrediente);
    }

    public String getTipoLanche() { return tipoLanche; }
    public List<String> getAdicionais() { return adicionais; }
    public List<String> getRemocoes() { return remocoes; }

    @Override
    public String toString() {
        return "Pedido interpretado{tipo=" + tipoLanche +
               ", adicionais=" + adicionais +
               ", remocoes=" + remocoes + "}";
    }
}
