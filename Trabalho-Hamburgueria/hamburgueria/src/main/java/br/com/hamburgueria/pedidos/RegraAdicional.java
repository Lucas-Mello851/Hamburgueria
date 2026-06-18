package br.com.hamburgueria.pedidos;

import br.com.hamburgueria.ingredientes.Molho;
import br.com.hamburgueria.produtos.Alface;
import br.com.hamburgueria.produtos.Bacon;
import br.com.hamburgueria.produtos.Queijo;
import br.com.hamburgueria.produtos.Tomate;


public class RegraAdicional implements RegraTextoPedido {

    @Override
    public void interpretar(PedidoTextoLido contexto) {
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
    }
}
