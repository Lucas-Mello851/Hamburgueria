package br.com.hamburgueria.ingredientes;

import java.util.ArrayList;
import java.util.List;

public class CatalogoIngredientes {

    private final List<Pao> paes = new ArrayList<>();
    private final List<Carne> carnes = new ArrayList<>();
    private final List<Molho> molhos = new ArrayList<>();
    private final EstoqueIngredientes estoque = new EstoqueIngredientes();

    public CatalogoIngredientes() {
        paes.add(new PaoBrioche());
        paes.add(new PaoIntegral());
        paes.add(new PaoPotato());
        carnes.add(new BlendBovino());
        carnes.add(new BlendGraoDeBico());
        carnes.add(new SmashDuplo());
        molhos.add(new MaioneseCaseira());
        molhos.add(new MolhoSmash());
        molhos.add(new MolhoVegano());
    }

    public List<Pao> getPaes() { return paes; }

    public List<Carne> getCarnes() { return carnes; }

    public List<Molho> getMolhos() { return molhos; }

    public List<String> listarDescricoes() {
        List<String> nomes = new ArrayList<>();
        for (Pao p : paes) { nomes.add(p.getDescricao()); }
        for (Carne c : carnes) { nomes.add(c.getDescricao()); }
        for (Molho m : molhos) { nomes.add(m.getDescricao()); }
        return nomes;
    }

    public List<IngredienteCompartilhado> compartilhados() {
        List<IngredienteCompartilhado> lista = new ArrayList<>();
        for (Pao p : paes) { lista.add(estoque.obterPao(p)); }
        for (Carne c : carnes) { lista.add(estoque.obterCarne(c)); }
        for (Molho m : molhos) { lista.add(estoque.obterMolho(m)); }
        return lista;
    }

    public int totalCompartilhadosEmCache() {
        compartilhados();
        return EstoqueIngredientes.getTotalCacheado();
    }

    private VisitanteFicha ultimoVisitante;

    public ResumoFichaTextual analisarFicha(FichaTecnica ficha) {
        VisitanteFicha visitante = new ResumoFichaTextual();
        this.ultimoVisitante = visitante;
        ficha.aceitar(visitante);
        return (ResumoFichaTextual) visitante;
    }

    public VisitanteFicha getUltimoVisitante() {
        return ultimoVisitante;
    }

    public double pesoTotalCarnes() {
        double total = 0;
        for (Carne c : carnes) { total += c.getPeso(); }
        return total;
    }

    public int getTotalIngredientes() {
        return paes.size() + carnes.size() + molhos.size();
    }
}
