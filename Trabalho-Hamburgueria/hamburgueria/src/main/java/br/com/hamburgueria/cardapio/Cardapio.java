package br.com.hamburgueria.cardapio;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cardapio {

    private static Cardapio instancia;

    private Cardapio() {
        registrarFabricas();
        registrarAdicionais();
    }

    public static synchronized Cardapio getInstance() {
        if (instancia == null) {
            instancia = new Cardapio();
        }
        return instancia;
    }

    private final Map<String, CriadorLanche> fabricas = new LinkedHashMap<>();

    private void registrarFabricas() {
        fabricas.put("Clássico", new CriadorLancheClassico());
        fabricas.put("Vegano",   new CriadorLancheVegano());
        fabricas.put("Smash",    new CriadorLancheSmash());
    }

    public CriadorLanche getFabrica(String tipo) {
        CriadorLanche fabrica = fabricas.get(tipo);
        if (fabrica == null) {
            throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
        return fabrica;
    }

    public Map<String, CriadorLanche> getFabricas() {
        return fabricas;
    }

    public br.com.hamburgueria.ingredientes.FornecedorIngredientes getFornecedorIngredientes(String tipo) {
        if ("Smash".equals(tipo)) {
            return new br.com.hamburgueria.ingredientes.FornecedorIngredientesSmash();
        } else if ("Vegano".equals(tipo)) {
            return new br.com.hamburgueria.ingredientes.FornecedorIngredientesVegano();
        } else if ("Clássico".equals(tipo)) {
            return new br.com.hamburgueria.ingredientes.FornecedorIngredientesClassico();
        }
        throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
    }

    private final Map<String, Double> adicionais = new LinkedHashMap<>();

    private void registrarAdicionais() {
        adicionais.put("Queijo Cheddar", Precos.ADICIONAL_QUEIJO);
        adicionais.put("Bacon Crocante", Precos.ADICIONAL_BACON);
        adicionais.put("Alface",         Precos.ADICIONAL_ALFACE);
        adicionais.put("Tomate",         Precos.ADICIONAL_TOMATE);
        adicionais.put("Molho Especial", Precos.ADICIONAL_MOLHO_ESPECIAL);
    }

    public Map<String, Double> getAdicionais() {
        return adicionais;
    }

    public String descreverCardapio() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARDAPIO - HAMBURGUERIA\n");
        sb.append("LANCHES BASE\n");
        fabricas.forEach((nome, fab) ->
            sb.append(String.format("%s R$ %.2f%n", nome, fab.criar().getPreco())));
        sb.append("ADICIONAIS\n");
        adicionais.forEach((nome, preco) ->
            sb.append(String.format("%s R$ %.2f%n", nome, preco)));
        return sb.toString();
    }
}

