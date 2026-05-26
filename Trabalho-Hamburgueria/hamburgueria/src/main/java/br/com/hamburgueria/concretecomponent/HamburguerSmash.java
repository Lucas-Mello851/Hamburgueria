package br.com.hamburgueria.concretecomponent;

import br.com.hamburgueria.abstractfactory.Carne;
import br.com.hamburgueria.abstractfactory.Molho;
import br.com.hamburgueria.abstractfactory.Pao;
import br.com.hamburgueria.component.Lanche;

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
        return 28.00;
    }
}
