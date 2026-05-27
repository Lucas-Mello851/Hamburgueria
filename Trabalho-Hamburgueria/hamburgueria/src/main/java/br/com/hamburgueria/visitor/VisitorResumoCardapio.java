package br.com.hamburgueria.visitor;

import br.com.hamburgueria.composite.Combo;
import br.com.hamburgueria.composite.ItemSimples;

import java.util.ArrayList;
import java.util.List;

public class VisitorResumoCardapio implements CardapioVisitor {

    private List<String> linhas;
    private double totalGeral;
    private int totalItens;

    public VisitorResumoCardapio() {
        linhas = new ArrayList<>();
        totalGeral = 0;
        totalItens = 0;
    }

    @Override
    public void visitarItemSimples(ItemSimples item) {
        String linha = "  Item: " + item.getNome() + " | R$ " + String.format("%.2f", item.getPreco());
        linhas.add(linha);
        totalGeral = totalGeral + item.getPreco();
        totalItens = totalItens + 1;
    }

    @Override
    public void visitarCombo(Combo combo) {
        String linha = "[Combo] " + combo.getNome() + " | R$ " + String.format("%.2f", combo.getPreco()) + " | " + combo.getItens().size() + " itens";
        linhas.add(linha);
        totalItens = totalItens + 1;
    }

    public void exibir() {
        System.out.println("===== RESUMO COMPLETO DO CARDAPIO =====");
        linhas.forEach(System.out::println);
        System.out.println("---------------------------------------");
        System.out.printf("Total de entradas: %d%n", totalItens);
        System.out.printf("Soma de itens simples: R$ %.2f%n", totalGeral);
        System.out.println("=======================================");
    }

    public double getTotalGeral() { return totalGeral; }
    public int getTotalItens() { return totalItens; }
}
