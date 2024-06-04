package ut4;

public class FactorialRecursivo {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}

