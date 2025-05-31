public class ArvoreBinaria {
    protected No raiz;

    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
    }

    public boolean estaVazia() {
        if(raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirRecursivoRedirecionamentoOtimizado(int conteudo) {
        No novoNo = new No(conteudo);
        this.raiz = inserirRecursivoOtimizado(this.raiz, novoNo);
    }

    private No inserirRecursivoOtimizado(No aux, No novoNo) {
        if(aux == null) {
            return novoNo;
        } else if (novoNo.getConteudo() > aux.getConteudo()) {
            aux.setDireita(inserirRecursivoOtimizado(aux.getDireita(), novoNo));
        } else {
            aux.setEsquerda(inserirRecursivoOtimizado(aux.getEsquerda(), novoNo));
        }

        return aux;
    }

    private void removerNo(int elemento){
        No filho = buscarFilhoRecursivo(raiz, elemento);
        No pai = buscarPaiRecursivo(raiz, filho);
        //Aqui já tenho o pai e o filho(quem quero remover) definidos.

        if(pai.getDireita() != null && pai.getEsquerda() != null){ //remover nó com 2 filhos

        }else if(pai.getDireita() != null && pai.getEsquerda() == null){//remover nó com 1 filho

        }else{ //Remover nó folha

        }


    }

    public void visualizar() {
        //preOrdem(this.raiz);
        //posOrdem(this.raiz);
        emOrdem(this.raiz);
    }

    public No buscarFilho(int elemento) {//Apenas chama Metodo buscarFilhoRecursivo
        return buscarFilhoRecursivo(this.raiz, elemento);
    }

    private No buscarFilhoRecursivo(No atual, int elemento) {
        if (atual == null) {
            return null;
        } //termina a busca se o No atual for nulo

        //retorna o No que contém o elemento
        if (atual.getConteudo() == elemento) {
            return atual;
        }

        //busca recursivamente na subarvore direita
        if (elemento > atual.getConteudo()) {
            return buscarFilhoRecursivo(atual.getDireita(), elemento);
        }

        //busca recursivamente na subarvore esquerda
        return buscarFilhoRecursivo(atual.getEsquerda(), elemento);
    }

    public No buscarPai(int elemento) {//Apenas chama Metodo buscarPaiRecursivo
        return buscarPaiRecursivo(this.raiz, buscarFilho(elemento));
         }

    private No buscarPaiRecursivo(No pai, No filho) {
        if(pai == null) { //caso o filho ou o pai seja nulo retorna nulo
            return null;
        }
        if(pai.getEsquerda() == filho || pai.getDireita() == filho) { //caso o NoFilho seja o filho das subarvores do NoPai retorna o pai
            return pai;
        }

        if (pai.getConteudo() > filho.getConteudo()){//Chama o metodo novamente atribuindo o Nopai como seu filho na subarvore a esquerda
            return buscarPaiRecursivo(pai.getEsquerda(), filho);
        }

        return buscarPaiRecursivo(pai.getDireita(), filho);
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }
}