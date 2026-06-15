package br.com.hamburgueria.interpreter;

public class InterpretadorRemocao implements ExpressaoPedido {

    @Override
    public void interpretar(ContextoPedidoTexto contexto) {
        String entrada = contexto.getEntrada();
        if (entrada.contains("sem tomate")) {
            contexto.removerIngrediente("Tomate");
        }
        if (entrada.contains("sem cebola")) {
            contexto.removerIngrediente("Cebola");
        }
        if (entrada.contains("sem alface")) {
            contexto.removerIngrediente("Alface");
        }
        if (entrada.contains("sem molho")) {
            contexto.removerIngrediente("Molho Especial");
        }
        if (!contexto.getRemocoes().isEmpty()) {
            System.out.println("Remocoes identificadas: " + contexto.getRemocoes());
        }
    }
}
