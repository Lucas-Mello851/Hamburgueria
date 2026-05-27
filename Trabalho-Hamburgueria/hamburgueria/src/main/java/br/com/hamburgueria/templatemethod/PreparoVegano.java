package br.com.hamburgueria.templatemethod;

public class PreparoVegano extends PreparoLanche {

    @Override
    protected void prepararCarne() {
        System.out.println("Grelhando blend de grao-de-bico por 5 minutos...");
    }

    @Override
    protected void montarIngredientes() {
        System.out.println("Montando: pao integral + blend vegano + alface + tomate + molho vegano...");
    }

    @Override
    protected void embalar() {
        System.out.println("Embalando com embalagem sustentavel...");
    }
}
