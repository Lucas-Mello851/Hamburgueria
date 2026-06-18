package br.com.hamburgueria.atendimento;

public class ReceitaClassico extends ReceitaLanche {

    @Override
    protected String prepararCarne() {
        return "Grelhar blend 160g na chapa por 4 minutos";
    }

    @Override
    protected String montarIngredientes() {
        return "Montar: pao brioche + blend + alface + tomate + maionese";
    }
}
