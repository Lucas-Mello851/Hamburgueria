package br.com.hamburgueria.templatemethod;

public class PreparoClassico extends PreparoLanche {

    @Override
    protected void prepararCarne() {
        System.out.println("Grelhando blend 160g na chapa por 4 minutos...");
    }

    @Override
    protected void montarIngredientes() {
        System.out.println("Montando: pao brioche + blend + alface + tomate + maionese...");
    }
}
