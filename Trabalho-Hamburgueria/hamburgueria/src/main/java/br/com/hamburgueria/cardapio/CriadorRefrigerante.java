package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.produtos.RefrigeranteLata;

public class CriadorRefrigerante implements CriadorBebida {
    @Override public Bebida criar() {
        return new RefrigeranteLata();
    }
}

