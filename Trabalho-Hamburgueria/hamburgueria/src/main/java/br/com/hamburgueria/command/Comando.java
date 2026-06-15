package br.com.hamburgueria.command;

public interface Comando {
    void executar();
    void desfazer();
}
