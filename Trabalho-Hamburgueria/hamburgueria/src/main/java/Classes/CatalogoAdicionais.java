package Classes;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CatalogoAdicionais {

    public static final String QUEIJO = "Queijo Cheddar";
    public static final String BACON = "Bacon Crocante";
    public static final String ALFACE = "Alface";
    public static final String TOMATE = "Tomate";
    public static final String MOLHO = "Molho Especial";

    private static final Map<String, Double> PRECOS = new LinkedHashMap<>();

    static {
        PRECOS.put(QUEIJO, 3.00);
        PRECOS.put(BACON, 4.00);
        PRECOS.put(ALFACE, 1.00);
        PRECOS.put(TOMATE, 1.00);
        PRECOS.put(MOLHO, 2.00);
    }

    private CatalogoAdicionais() {}

    public static boolean existe(String adicional) {
        return PRECOS.containsKey(adicional);
    }

    public static double getPreco(String adicional) {
        return PRECOS.getOrDefault(adicional, 0.0);
    }

    public static Map<String, Double> todos() {
        return new LinkedHashMap<>(PRECOS);
    }
}
