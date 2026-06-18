package br.com.hamburgueria.atendimento;

public class ReceitaVegano extends ReceitaLanche {

    @Override
    protected String prepararCarne() {
        return "Grelhar blend de grao-de-bico por 5 minutos";
    }

    @Override
    protected String montarIngredientes() {
        return "Montar: pao integral + blend vegano + alface + tomate + molho vegano";
    }

    @Override
    protected String embalar() {
        return "Embalar com embalagem sustentavel";
    }
}
