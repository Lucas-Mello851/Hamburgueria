package br.com.hamburgueria.composite;

import br.com.hamburgueria.cardapio.Cardapio;

import java.util.LinkedHashMap;
import java.util.Map;

public class CardapioComCombos {

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
        comboClassico.adicionar(new ItemSimples("Refrigerante Lata", 6.00));
        comboClassico.adicionar(new ItemSimples("Batata Pequena", 8.00));
        combos.put("Combo Classico", comboClassico);

        Combo comboSmash = new Combo("Combo Smash");
        comboSmash.adicionar(new ItemSimples("Hamburguer Smash", cardapio.getFabrica("Smash").criar().getPreco()));
        comboSmash.adicionar(new ItemSimples("Refrigerante Lata", 6.00));
        comboSmash.adicionar(new ItemSimples("Batata Media", 10.00));
        combos.put("Combo Smash", comboSmash);

        Combo comboVegano = new Combo("Combo Vegano");
        comboVegano.adicionar(new ItemSimples("Hamburguer Vegano", cardapio.getFabrica("Vegano").criar().getPreco()));
        comboVegano.adicionar(new ItemSimples("Suco Natural", 8.00));
        comboVegano.adicionar(new ItemSimples("Salada de Frutas", 7.00));
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

    public void exibirCombos() {
        System.out.println("\n===== COMBOS DO CARDAPIO =====");
        combos.values().forEach(c -> c.exibir(""));
        System.out.println("==============================\n");
    }
}
