package br.com.hamburgueria.cardapio;



import java.util.ArrayList;
import java.util.List;

public class PercursoCardapioCompleto implements PercursoCardapio {

    private final List<ItemCardapio> itens = new ArrayList<>();
    private int posicao = 0;

    public PercursoCardapioCompleto(List<Combo> combos) {
        for (Combo combo : combos) {
            itens.add(combo);
            itens.addAll(combo.getItens());
        }
    }

    @Override
    public boolean temProximo() {
        return posicao < itens.size();
    }

    @Override
    public ItemCardapio proximo() {
        if (!temProximo()) throw new IllegalStateException("Sem mais itens.");
        return itens.get(posicao++);
    }

    @Override
    public void reiniciar() {
        posicao = 0;
    }

    public int getTotalItens() {
        return itens.size();
    }
}
