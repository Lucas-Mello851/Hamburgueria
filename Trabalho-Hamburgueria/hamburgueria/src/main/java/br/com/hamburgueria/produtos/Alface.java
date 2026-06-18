package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;



public class Alface extends Adicional {
    public Alface(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Alface"; }

    @Override
    public double getPreco() { return lanche.getPreco() + Precos.ADICIONAL_ALFACE; }
}
