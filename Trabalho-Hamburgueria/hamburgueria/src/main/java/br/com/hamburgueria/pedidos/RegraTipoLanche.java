package br.com.hamburgueria.pedidos;

public class RegraTipoLanche implements RegraTextoPedido {

    @Override
    public void interpretar(PedidoTextoLido contexto) {
        String entrada = contexto.getEntrada();
        if (entrada.contains("smash")) {
            contexto.setTipoLanche("Smash");
        } else if (entrada.contains("vegano")) {
            contexto.setTipoLanche("Vegano");
        } else if (entrada.contains("classico") || entrada.contains("clássico")) {
            contexto.setTipoLanche("Clássico");
        } else {
            contexto.setTipoLanche("Clássico");
        }
    }
}
