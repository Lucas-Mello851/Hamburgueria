package br.com.hamburgueria.pedidos;

public class RegraAdicional implements RegraTextoPedido {

    @Override
    public void interpretar(PedidoTextoLido contexto) {
        String entrada = contexto.getEntrada();
        if (entrada.contains("queijo") && !entrada.contains("sem queijo")) {
            contexto.adicionarIngrediente("Queijo Cheddar");
        }
        if (entrada.contains("bacon") && !entrada.contains("sem bacon")) {
            contexto.adicionarIngrediente("Bacon Crocante");
        }
        if (entrada.contains("alface") && !entrada.contains("sem alface")) {
            contexto.adicionarIngrediente("Alface");
        }
        if (entrada.contains("tomate") && !entrada.contains("sem tomate")) {
            contexto.adicionarIngrediente("Tomate");
        }
        if (entrada.contains("molho") && !entrada.contains("sem molho")) {
            contexto.adicionarIngrediente("Molho Especial");
        }
    }
}

