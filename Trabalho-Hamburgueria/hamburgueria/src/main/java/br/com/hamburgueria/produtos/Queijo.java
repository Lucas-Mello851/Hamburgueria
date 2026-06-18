package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;



public class Queijo extends Adicional {
    public Queijo(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Queijo Cheddar"; }

    @Override
    public double getPreco() { return lanche.getPreco() + Precos.ADICIONAL_QUEIJO; }
}
