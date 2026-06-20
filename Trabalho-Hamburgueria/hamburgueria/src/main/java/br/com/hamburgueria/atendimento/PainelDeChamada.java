package br.com.hamburgueria.atendimento;

import java.util.ArrayList;
import java.util.List;

public class PainelDeChamada implements AcompanhantepPedido {

    private final List<String> emPreparo = new ArrayList<>();
    private final List<String> prontosParaRetirada = new ArrayList<>();
    private String ultimoChamado;

    @Override
    public void atualizar(String evento, String descricaoPedido) {
        if ("NOVO_PEDIDO".equals(evento)) {
            emPreparo.add(descricaoPedido);
        } else if ("PEDIDO_PRONTO".equals(evento)) {
            emPreparo.remove(descricaoPedido);
            prontosParaRetirada.add(descricaoPedido);
            ultimoChamado = descricaoPedido;
        }
    }

    public List<String> getEmPreparo() {
        return emPreparo;
    }

    public List<String> getProntosParaRetirada() {
        return prontosParaRetirada;
    }

    public String getUltimoChamado() {
        return ultimoChamado;
    }

    public String exibirPainel() {
        if (ultimoChamado == null) {
            return "Nenhum pedido pronto no momento.";
        }
        return "PEDIDO PRONTO: " + ultimoChamado + " - retire no balcao!";
    }
}

