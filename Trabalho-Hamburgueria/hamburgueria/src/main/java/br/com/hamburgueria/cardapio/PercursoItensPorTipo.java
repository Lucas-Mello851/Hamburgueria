package br.com.hamburgueria.cardapio;



import java.util.ArrayList;
import java.util.List;

public class PercursoItensPorTipo implements PercursoCardapio {

    private final List<ItemCardapio> itensFiltrados = new ArrayList<>();
    private int posicao = 0;

    public PercursoItensPorTipo(List<Combo> combos, Class<? extends ItemCardapio> tipo) {
        for (Combo combo : combos) {
            if (tipo.isInstance(combo)) {
                itensFiltrados.add(combo);
            }
            for (ItemCardapio item : combo.getItens()) {
                if (tipo.isInstance(item)) {
                    itensFiltrados.add(item);
                }
            }
        }
    }

    @Override
    public boolean temProximo() {
        return posicao < itensFiltrados.size();
    }

    @Override
    public ItemCardapio proximo() {
        if (!temProximo()) throw new IllegalStateException("Sem mais itens.");
        return itensFiltrados.get(posicao++);
    }

    @Override
    public void reiniciar() {
        posicao = 0;
    }

    public int getTotalItens() {
        return itensFiltrados.size();
    }
}
