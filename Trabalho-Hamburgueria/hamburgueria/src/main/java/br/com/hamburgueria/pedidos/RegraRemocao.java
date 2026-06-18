package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.ingredientes.Molho;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Tomate;


public class RegraRemocao implements RegraTextoPedido {

    @Override
    public void interpretar(PedidoTextoLido contexto) {
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
    }
}
