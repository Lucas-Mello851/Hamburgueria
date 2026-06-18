package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.ingredientes.FornecedorIngredientes;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesVegano;
import br.com.hamburgueria.produtos.HamburguerVegano;
import br.com.hamburgueria.produtos.Lanche;



public class CriadorLancheVegano implements CriadorLanche {

    private final FornecedorIngredientes ingredientesFactory = new FornecedorIngredientesVegano();

    @Override
    public Lanche criar() {
        return new HamburguerVegano(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
