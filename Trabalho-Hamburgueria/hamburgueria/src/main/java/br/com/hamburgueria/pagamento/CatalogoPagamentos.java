package br.com.hamburgueria.pagamento;

import java.util.LinkedHashMap;
import java.util.Map;

public class CatalogoPagamentos {

    private final Map<String, FormaPagamento> formas = new LinkedHashMap<>();

    public CatalogoPagamentos() {
        formas.put("PIX", new PagamentoPix());
        formas.put("DINHEIRO", new PagamentoDinheiro());
        formas.put("CREDITO", new PagamentoCartao("Credito"));
        formas.put("DEBITO", new PagamentoCartao("Debito"));
    }

    public FormaPagamento obter(String chave) {
        FormaPagamento forma = formas.get(chave == null ? "" : chave.trim().toUpperCase());
        if (forma == null) {
            throw new IllegalArgumentException("Forma de pagamento desconhecida: " + chave);
        }
        return forma;
    }

    public FormaPagamento pix() {
        return obter("PIX");
    }

    public FormaPagamento dinheiro() {
        return obter("DINHEIRO");
    }

    public FormaPagamento cartaoCredito() {
        return obter("CREDITO");
    }

    public FormaPagamento cartaoDebito() {
        return obter("DEBITO");
    }

    public FormaPagamento maquininhaParceira(String operadora) {
        return new MaquininhaParceira(new MaquininhaExterna(operadora));
    }

    public int getTotalFormas() {
        return formas.size();
    }
}
