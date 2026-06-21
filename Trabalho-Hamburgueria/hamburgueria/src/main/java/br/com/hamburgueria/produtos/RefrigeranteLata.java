package br.com.hamburgueria.produtos;

import br.com.hamburgueria.cardapio.Precos;

public class RefrigeranteLata implements Bebida {
    @Override public String getDescricao() { return "Refrigerante lata 350ml"; }
    @Override public double getPreco() { return Precos.REFRIGERANTE_LATA; }
}

