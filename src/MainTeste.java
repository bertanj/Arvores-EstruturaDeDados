public class MainTeste {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(20);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(10);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(30);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(5);
        arvoreBinaria.inserirRecursivoRedirecionamentoOtimizado(35);

        arvoreBinaria.removerNo(10);
        arvoreBinaria.visualizar();
    }
}
