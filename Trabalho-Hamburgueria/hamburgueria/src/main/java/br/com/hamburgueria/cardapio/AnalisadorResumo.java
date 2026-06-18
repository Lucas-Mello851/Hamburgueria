package br.com.hamburgueria.cardapio;



import java.util.ArrayList;
import java.util.List;

public class AnalisadorResumo implements AnalisadorCardapio {

    private List<String> linhas;
    private double totalGeral;
    private int totalItens;

    public AnalisadorResumo() {
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

    public List<String> getLinhas() {
        return linhas;
    }

    public double getTotalGeral() { return totalGeral; }
    public int getTotalItens() { return totalItens; }
}
