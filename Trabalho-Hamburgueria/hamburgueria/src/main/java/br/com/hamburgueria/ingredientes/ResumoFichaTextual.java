package br.com.hamburgueria.ingredientes;

public class ResumoFichaTextual implements VisitanteFicha {

    private final StringBuilder texto = new StringBuilder();
    private int totalItens = 0;

    @Override
    public void visitarLinha(FichaTecnica.LinhaFicha linha) {
        texto.append("- ").append(linha.descrever()).append("\n");
        totalItens += linha.getQuantidade();
    }

    public String getTexto() { return texto.toString(); }
    public int getTotalItens() { return totalItens; }
}

