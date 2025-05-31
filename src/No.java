public class No {
    private int conteudo;
    private No esquerda;
    private No direita;

    public No (int conteudo) {
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}