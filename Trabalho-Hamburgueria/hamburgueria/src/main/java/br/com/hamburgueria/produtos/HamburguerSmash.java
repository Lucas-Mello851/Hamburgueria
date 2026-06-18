package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;
import br.com.hamburgueria.ingredientes.Carne;
import br.com.hamburgueria.ingredientes.Molho;
import br.com.hamburgueria.ingredientes.Pao;



public class HamburguerSmash implements Lanche {

    private final Pao pao;
    private final Carne carne;
    private final Molho molho;

    public HamburguerSmash() {
        this.pao = null;
        this.carne = null;
        this.molho = null;
    }

    public HamburguerSmash(Pao pao, Carne carne, Molho molho) {
        this.pao = pao;
        this.carne = carne;
        this.molho = molho;
    }

    @Override
    public String getDescricao() {
        if (pao != null) {
            return "Smash Burger (" + pao.getDescricao() + " + " + carne.getDescricao() + " + " + molho.getDescricao() + ")";
        }
        return "Smash Burger (Pão Potato + 2x Smash 80g)";
    }

    @Override
    public double getPreco() {
        return Precos.HAMBURGUER_SMASH;
    }
}
