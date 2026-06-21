package br.com.hamburgueria.ingredientes;

import java.util.ArrayList;
import java.util.List;
import br.com.hamburgueria.produtos.Lanche;

public class FichaTecnica {

    public static class LinhaFicha {
        private final IngredienteCompartilhado ingrediente;
        private final int quantidade;

        public LinhaFicha(IngredienteCompartilhado ingrediente, int quantidade) {
            this.ingrediente = ingrediente;
            this.quantidade = quantidade;
        }

        public IngredienteCompartilhado getIngrediente() { return ingrediente; }
        public int getQuantidade() { return quantidade; }

        public String descrever() {
            return quantidade + "x " + ingrediente.getDescricao()
                    + " (" + ingrediente.getTipo() + ")";
        }
    }

    private final String nomeLanche;
    private final List<LinhaFicha> linhas;
    private final EstoqueIngredientes estoque = new EstoqueIngredientes();
    private Lanche lanche;

    public void associarLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public boolean confereComLanche() {
        return lanche != null && lanche.getDescricao() != null;
    }

    public FichaTecnica(String nomeLanche) {
        this.nomeLanche = nomeLanche;
        this.linhas = new ArrayList<>();
    }

    public static FichaTecnica montar(String nomeLanche, FornecedorIngredientes fornecedor,
                                      int qtdPao, int qtdCarne, int qtdMolho) {
        FichaTecnica ficha = new FichaTecnica(nomeLanche);
        ficha.linhas.add(new LinhaFicha(
                ficha.estoque.obterPao(fornecedor.criarPao()), qtdPao));
        ficha.linhas.add(new LinhaFicha(
                ficha.estoque.obterCarne(fornecedor.criarCarne()), qtdCarne));
        ficha.linhas.add(new LinhaFicha(
                ficha.estoque.obterMolho(fornecedor.criarMolho()), qtdMolho));
        return ficha;
    }

    public String getNomeLanche() { return nomeLanche; }

    public List<LinhaFicha> getLinhas() { return linhas; }

    public int getTotalIngredientes() {
        int total = 0;
        for (LinhaFicha linha : linhas) {
            total += linha.getQuantidade();
        }
        return total;
    }

    public String descrever() {
        StringBuilder sb = new StringBuilder("Ficha Tecnica - " + nomeLanche + ":\n");
        for (LinhaFicha linha : linhas) {
            sb.append("  ").append(linha.descrever()).append("\n");
        }
        return sb.toString();
    }

    public void aceitar(VisitanteFicha visitante) {
        for (LinhaFicha linha : linhas) {
            visitante.visitarLinha(linha);
        }
    }
}

