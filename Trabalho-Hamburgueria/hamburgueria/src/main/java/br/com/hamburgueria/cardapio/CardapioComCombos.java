package br.com.hamburgueria.cardapio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CardapioComCombos implements CardapioPercorrivel {

    private static final CardapioComCombos INSTANCIA = new CardapioComCombos();

    private final Map<String, Combo> combos = new LinkedHashMap<>();

    private CardapioComCombos() {
        registrarCombos();
    }

    public static CardapioComCombos getInstance() {
        return INSTANCIA;
    }

    private void registrarCombos() {
        Cardapio cardapio = Cardapio.getInstance();

        Combo comboClassico = new Combo("Combo Classico");
        comboClassico.adicionar(new ItemSimples("Hamburguer Classico", cardapio.getFabrica("Clássico").criar().getPreco()));
        comboClassico.adicionar(new ItemSimples("Refrigerante Lata", Precos.REFRIGERANTE_LATA));
        comboClassico.adicionar(new ItemSimples("Batata Pequena", Precos.BATATA_PEQUENA));
        combos.put("Combo Classico", comboClassico);

        Combo comboSmash = new Combo("Combo Smash");
        comboSmash.adicionar(new ItemSimples("Hamburguer Smash", cardapio.getFabrica("Smash").criar().getPreco()));
        comboSmash.adicionar(new ItemSimples("Refrigerante Lata", Precos.REFRIGERANTE_LATA));
        comboSmash.adicionar(new ItemSimples("Batata Media", Precos.BATATA_MEDIA));
        combos.put("Combo Smash", comboSmash);

        Combo comboVegano = new Combo("Combo Vegano");
        comboVegano.adicionar(new ItemSimples("Hamburguer Vegano", cardapio.getFabrica("Vegano").criar().getPreco()));
        comboVegano.adicionar(new ItemSimples("Suco Natural", Precos.SUCO_NATURAL));
        comboVegano.adicionar(new ItemSimples("Salada de Frutas", Precos.SALADA_FRUTAS));
        combos.put("Combo Vegano", comboVegano);
    }

    public Combo getCombo(String nome) {
        Combo c = combos.get(nome);
        if (c == null) throw new IllegalArgumentException("Combo nao encontrado: " + nome);
        return c;
    }

    public Map<String, Combo> getCombos() {
        return combos;
    }

    public String descreverCombos() {
        StringBuilder sb = new StringBuilder();
        combos.values().forEach(c -> sb.append(c.descrever("")).append("\n"));
        return sb.toString();
    }

    @Override
    public PercursoCardapio criarIterator() {
        return new PercursoCardapioCompleto(new ArrayList<>(combos.values()));
    }

    private AnalisadorCardapio ultimoAnalisador;

    public void analisar(AnalisadorCardapio analisador) {
        this.ultimoAnalisador = analisador;
        for (Combo combo : combos.values()) {
            combo.aceitar(analisador);
        }
    }

    public AnalisadorCardapio getUltimoAnalisador() {
        return ultimoAnalisador;
    }
}

