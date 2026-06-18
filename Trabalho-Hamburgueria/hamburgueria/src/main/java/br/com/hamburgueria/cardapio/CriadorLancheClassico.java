package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.ingredientes.FornecedorIngredientes;
import br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico;
import br.com.hamburgueria.produtos.HamburguerClassico;
import br.com.hamburgueria.produtos.Lanche;



public class CriadorLancheClassico implements CriadorLanche {

    private final FornecedorIngredientes ingredientesFactory = new FornecedorIngredientesClassico();

    @Override
    public Lanche criar() {
        return new HamburguerClassico(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
