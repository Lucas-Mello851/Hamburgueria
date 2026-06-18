package br.com.hamburgueria.cardapio;



import java.util.ArrayList;
import java.util.List;

public class AnalisadorPorPreco implements AnalisadorCardapio {

    private final double precoMaximo;
    private final List<String> itensFiltrados = new ArrayList<>();

    public AnalisadorPorPreco(double precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    @Override
    public void visitarItemSimples(ItemSimples item) {
        if (item.getPreco() <= precoMaximo) {
            itensFiltrados.add(item.getNome() + " - R$ " + String.format("%.2f", item.getPreco()));
        }
    }

    @Override
    public void visitarCombo(Combo combo) {
        if (combo.getPreco() <= precoMaximo) {
            itensFiltrados.add("[Combo] " + combo.getNome() + " - R$ " + String.format("%.2f", combo.getPreco()));
        }
    }

    public List<String> getItensFiltrados() {
        return itensFiltrados;
    }
}
