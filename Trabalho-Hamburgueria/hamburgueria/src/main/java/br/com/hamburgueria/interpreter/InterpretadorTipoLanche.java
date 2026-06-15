package br.com.hamburgueria.interpreter;

public class InterpretadorTipoLanche implements ExpressaoPedido {

    @Override
    public void interpretar(ContextoPedidoTexto contexto) {
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
        System.out.println("Tipo identificado: " + contexto.getTipoLanche());
    }
}
