public class MainTeste {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(10);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(5);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(15);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(1);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(12);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(11);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(76);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(32);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(50);

        System.out.println(arvoreBinaria.buscarFilho(76).getConteudo());
        System.out.println(arvoreBinaria.buscarPai(76).getConteudo());

    }
}
