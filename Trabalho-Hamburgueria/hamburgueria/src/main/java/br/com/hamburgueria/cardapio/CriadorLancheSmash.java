package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.ingredientes.FornecedorIngredientes;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesSmash;
import br.com.hamburgueria.produtos.HamburguerSmash;
import br.com.hamburgueria.produtos.Lanche;



public class CriadorLancheSmash implements CriadorLanche {

    private final FornecedorIngredientes ingredientesFactory = new FornecedorIngredientesSmash();

    @Override
    public Lanche criar() {
        return new HamburguerSmash(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
