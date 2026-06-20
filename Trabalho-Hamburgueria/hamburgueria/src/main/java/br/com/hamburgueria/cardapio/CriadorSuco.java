package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.produtos.Bebida;
import br.com.hamburgueria.produtos.SucoNatural;

public class CriadorSuco implements CriadorBebida {
    @Override public Bebida criar() {
        return new SucoNatural();
    }
}

