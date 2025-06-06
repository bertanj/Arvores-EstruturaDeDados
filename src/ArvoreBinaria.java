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

    public void removerNo(int elemento){
        No filho = buscarFilhoRecursivo(raiz, elemento);
        No pai = buscarPaiRecursivo(raiz, filho);
        //Aqui já tenho o pai e o filho(quem quero remover) definidos.

        if (filho == null){ //Se filho for nulo o elemento não existe na árvore
            return;
        }

        if(filho.getDireita() != null && filho.getEsquerda() != null){ //remover nó com 2 filhos
            removerNo2Filhos(filho);

        }else if(filho.getDireita() != null || filho.getEsquerda() != null){//remover nó com 1 filho
            removerNo1Filho(pai,filho);
        }else {//Remover nó folha
            removerNoFolha(pai,filho);
        }
    }

    private No removerNo2Filhos(No filho){
        //selecionar maior dos menores
        No maior = filho.getEsquerda();
        No paiDoMaior = filho;
        while(maior.getDireita() != null){
            paiDoMaior = maior;
            maior = maior.getDireita();
        }
        filho.setConteudo(maior.getConteudo());

        if (paiDoMaior == filho){ //caso paiDoMaior seja == filho quer dizer q o maior é filho direto do elemento q iremos remover logo mudamos o apontamento dele para o apontamento do maior.getesquerda por ele ser o maior temos a certeza q não terá filho a direita
            filho.setEsquerda(maior.getEsquerda());
        }else{//caso não seja, ajustamos o apontamento da direita do paiDoMaior para maior.getEsquerda para caso haja algum filho a esquerda do maior já que o filho a esquerda do maior será maior que o paiDoMaior, caso não haja filho apenas será mudado o apontamento para nulo
            paiDoMaior.setDireita(maior.getEsquerda());
        }
        return filho;
    }

    private No removerNo1Filho(No pai,No filho){
        if (filho.getDireita() != null){ //verifica em qual direção o nó filho tem subarvore
            if (pai.getConteudo() < filho.getConteudo()){ //se o pai for menor que o filho (elemento a ser removido) irá alterar o apontamento da direita para o "neto"
                pai.setDireita(filho.getDireita());
            }else {
                pai.setEsquerda(filho.getDireita());
            }
        }else {
            if (pai.getConteudo() < filho.getConteudo()){
                pai.setDireita(filho.getEsquerda());
            }else {
                pai.setEsquerda(filho.getEsquerda());
            }
        }
        return pai;
    }

    private No removerNoFolha(No pai, No filho){
        if (pai.getConteudo() < filho.getConteudo()){
            pai.setDireita(null);
        }else {
            pai.setEsquerda(null);
        }
        return pai;
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
        if (filho == null){
            System.out.println("elemento não existe na árvore");
        }else {

            if (pai == null) { //caso o filho ou o pai seja nulo retorna nulo
                return null;
            }

            if (pai.getEsquerda() == filho || pai.getDireita() == filho) { //caso o NoFilho seja o filho das subarvores do NoPai retorna o pai
                return pai;
            }

            if (pai.getConteudo() > filho.getConteudo()) {//Chama o metodo novamente atribuindo o Nopai como seu filho na subarvore a esquerda
                return buscarPaiRecursivo(pai.getEsquerda(), filho);
            }

            return buscarPaiRecursivo(pai.getDireita(), filho); //Chama o metodo novamente atribuindo o Nopai como seu filho na subarvore a direita
        }
        return null;
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