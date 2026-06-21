package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;

public class SucoNatural implements Bebida {
    @Override public String getDescricao() { return "Suco natural 400ml"; }
    @Override public double getPreco() { return Precos.SUCO_NATURAL; }
}

