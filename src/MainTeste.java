public class MainTeste {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(50);

        System.out.println("Inserções iniciais:");
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(30);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(70);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(20);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(40);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(60);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(80);
        arvoreBinaria.visualizar();

        System.out.println("\nRemoção de folha (20):");
        arvoreBinaria.removerNo(20);
        arvoreBinaria.visualizar();

        System.out.println("\nRemoção de nó com um filho (30):");
        arvoreBinaria.removerNo(30);
        arvoreBinaria.visualizar();

        System.out.println("\nRemoção de nó com dois filhos (70):");
        arvoreBinaria.removerNo(70);
        arvoreBinaria.visualizar();

        System.out.println("\nRemoção do nó raiz (50):");
        arvoreBinaria.removerNo(50);
        arvoreBinaria.visualizar();

        System.out.println("\nRemoção de nó inexistente (999):");
        arvoreBinaria.removerNo(999);
        arvoreBinaria.visualizar();

        System.out.println("\nInserções adicionais após remoções:");
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(90);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(10);
        arvoreBinaria.visualizar();
    }
}