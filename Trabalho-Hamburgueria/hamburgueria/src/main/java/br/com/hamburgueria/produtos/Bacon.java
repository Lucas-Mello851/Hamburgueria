package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;



public class Bacon extends Adicional {
    public Bacon(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + Bacon Crocante"; }

    @Override
    public double getPreco() { return lanche.getPreco() + Precos.ADICIONAL_BACON; }
}
