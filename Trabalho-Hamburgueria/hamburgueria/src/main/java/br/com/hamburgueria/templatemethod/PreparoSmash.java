package br.com.hamburgueria.templatemethod;

public class PreparoSmash extends PreparoLanche {

    @Override
    protected void prepararCarne() {
        System.out.println("Smashando 2x 80g na chapa bem quente...");
    }

    @Override
    protected void montarIngredientes() {
        System.out.println("Montando: pao potato + 2x smash + queijo derretido...");
    }
}
