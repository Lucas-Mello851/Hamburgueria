package br.com.hamburgueria.visitor;

import br.com.hamburgueria.composite.Combo;
import br.com.hamburgueria.composite.ItemSimples;

import java.util.ArrayList;
import java.util.List;

public class VisitorItensPorPreco implements CardapioVisitor {

    private final double precoMaximo;
    private final List<String> itensFiltrados = new ArrayList<>();

    public VisitorItensPorPreco(double precoMaximo) {
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

    public void exibir() {
        System.out.println("Itens ate R$ " + String.format("%.2f", precoMaximo) + ":");
        if (itensFiltrados.isEmpty()) {
            System.out.println("  Nenhum item encontrado.");
        } else {
            itensFiltrados.forEach(i -> System.out.println("  " + i));
        }
    }
}
