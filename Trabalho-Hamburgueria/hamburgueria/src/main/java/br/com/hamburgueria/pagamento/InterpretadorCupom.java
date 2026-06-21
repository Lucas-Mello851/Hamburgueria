package br.com.hamburgueria.pagamento;

import java.util.ArrayList;
import java.util.List;

public class InterpretadorCupom {

    private final List<RegraCupom> regras = new ArrayList<>();

    public InterpretadorCupom() {
        regras.add(new RegraCupomEstudante());
        regras.add(new RegraCupomFidelidade());
        regras.add(new RegraCupomPromocional());
    }

    public PoliticaDesconto interpretar(String cupom) {
        if (cupom != null) {
            String token = cupom.trim();
            for (RegraCupom regra : regras) {
                PoliticaDesconto politica = regra.interpretar(token);
                if (politica != null) {
                    return politica;
                }
            }
        }
        return new DescontoPadrao();
    }

    public boolean cupomValido(String cupom) {
        return !(interpretar(cupom) instanceof DescontoPadrao) || "PADRAO".equalsIgnoreCase(cupom);
    }
}

