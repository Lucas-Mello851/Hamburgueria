package Classes;

import Classes.IngredientesClassicoFactory;
import Classes.IngredientesFactory;
import Classes.Lanche;
import Classes.HamburguerClassico;

public class ClassicoFactory implements LancheFactory {

    private final IngredientesFactory ingredientesFactory = new IngredientesClassicoFactory();

    @Override
    public Lanche criar() {
        return new HamburguerClassico(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
