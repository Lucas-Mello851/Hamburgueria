package br.com.hamburgueria.abstractfactory;

public class IngredientesSmashFactory implements IngredientesFactory {
    @Override
    public Pao criarPao() { return new PaoPotato(); }
    @Override
    public Carne criarCarne() { return new SmashDuplo(); }
    @Override
    public Molho criarMolho() { return new MolhoSmash(); }
}
