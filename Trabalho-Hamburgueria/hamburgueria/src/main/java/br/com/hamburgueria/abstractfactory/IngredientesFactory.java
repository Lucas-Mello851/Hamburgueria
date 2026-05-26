package br.com.hamburgueria.abstractfactory;

public interface IngredientesFactory {
    Pao criarPao();
    Carne criarCarne();
    Molho criarMolho();
}
