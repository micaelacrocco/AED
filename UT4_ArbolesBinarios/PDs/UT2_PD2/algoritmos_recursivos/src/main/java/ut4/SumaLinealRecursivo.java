package ut4;

public class SumaLinealRecursivo {
    public static int SumaLineal(int[] A, int n) {
        if (n < 0 || n > A.length) {
            throw new IllegalArgumentException("El tamaño del vector es inválido");
        }
        if (n == 0)
            return 0;
        else
            return A[n - 1] + SumaLineal(A, n - 1);
    }
}
