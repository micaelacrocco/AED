package ut3;

public class AlgoritmoBurbuja {
    private static int contadorSi = 0;

    public static void ordenar(int[] arreglo) {
        int N = arreglo.length;
        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j >= i + 1; j--) {
                if (arreglo[j] < arreglo[j - 1]) {
                    intercambiar(arreglo, j, j - 1);
                    contadorSi++;
                }
            }
        }
    }

    private static void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    public static int getContadorSi() {
        return contadorSi;
    }
}

