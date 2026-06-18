package br.com.hamburgueria.atendimento;

public class ReceitaSmash extends ReceitaLanche {

    @Override
    protected String prepararCarne() {
        return "Smashar 2x 80g na chapa bem quente";
    }

    @Override
    protected String montarIngredientes() {
        return "Montar: pao potato + 2x smash + queijo derretido";
    }
}
