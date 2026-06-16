package Classes;

import Classes.IngredientesFactory;
import Classes.IngredientesSmashFactory;
import Classes.Lanche;
import Classes.HamburguerSmash;

public class SmashFactory implements LancheFactory {

    private final IngredientesFactory ingredientesFactory = new IngredientesSmashFactory();

    @Override
    public Lanche criar() {
        return new HamburguerSmash(
            ingredientesFactory.criarPao(),
            ingredientesFactory.criarCarne(),
            ingredientesFactory.criarMolho()
        );
    }
}
