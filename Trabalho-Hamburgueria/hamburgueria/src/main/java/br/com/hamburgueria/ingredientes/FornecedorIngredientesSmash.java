package br.com.hamburgueria.ingredientes;

public class FornecedorIngredientesSmash implements FornecedorIngredientes {
    @Override
    public Pao criarPao() { return new PaoPotato(); }
    @Override
    public Carne criarCarne() { return new SmashDuplo(); }
    @Override
    public Molho criarMolho() { return new MolhoSmash(); }
}
