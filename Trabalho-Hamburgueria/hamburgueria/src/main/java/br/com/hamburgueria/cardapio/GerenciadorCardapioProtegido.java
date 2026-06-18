package br.com.hamburgueria.cardapio;

public class GerenciadorCardapioProtegido implements GerenciadorCardapio {

    private GerenciadorCardapioInterno gerenciadorReal;
    private NivelAcesso nivelAcesso;

    public GerenciadorCardapioProtegido(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
        this.gerenciadorReal = new GerenciadorCardapioInterno();
    }

    private boolean temPermissao() {
        return nivelAcesso == NivelAcesso.GERENTE;
    }

    @Override
    public boolean adicionarItem(String nome, double preco) {
        if (!temPermissao()) {
            return false;
        }
        return gerenciadorReal.adicionarItem(nome, preco);
    }

    @Override
    public boolean removerItem(String nome) {
        if (!temPermissao()) {
            return false;
        }
        return gerenciadorReal.removerItem(nome);
    }

    @Override
    public boolean alterarPreco(String nome, double novoPreco) {
        if (!temPermissao()) {
            return false;
        }
        return gerenciadorReal.alterarPreco(nome, novoPreco);
    }

    @Override
    public boolean contemItem(String nome) {
        return gerenciadorReal.contemItem(nome);
    }

    @Override
    public int getTotalItens() {
        return gerenciadorReal.getTotalItens();
    }
}
