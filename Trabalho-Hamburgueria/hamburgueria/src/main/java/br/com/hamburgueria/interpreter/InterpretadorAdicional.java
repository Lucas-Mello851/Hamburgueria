package br.com.hamburgueria.interpreter;

public class InterpretadorAdicional implements ExpressaoPedido {

    @Override
    public void interpretar(ContextoPedidoTexto contexto) {
        String entrada = contexto.getEntrada();
        if (entrada.contains("queijo")) {
            contexto.adicionarIngrediente("Queijo Cheddar");
        }
        if (entrada.contains("bacon")) {
            contexto.adicionarIngrediente("Bacon Crocante");
        }
        if (entrada.contains("alface")) {
            contexto.adicionarIngrediente("Alface");
        }
        if (entrada.contains("tomate") && !entrada.contains("sem tomate")) {
            contexto.adicionarIngrediente("Tomate");
        }
        if (entrada.contains("molho")) {
            contexto.adicionarIngrediente("Molho Especial");
        }
        System.out.println("Adicionais identificados: " + contexto.getAdicionais());
    }
}
