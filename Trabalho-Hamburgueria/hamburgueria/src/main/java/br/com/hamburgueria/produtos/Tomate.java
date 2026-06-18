package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;



public class Tomate extends Adicional {
    public Tomate(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Tomate"; }

    @Override
    public double getPreco() { return lanche.getPreco() + Precos.ADICIONAL_TOMATE; }
}
