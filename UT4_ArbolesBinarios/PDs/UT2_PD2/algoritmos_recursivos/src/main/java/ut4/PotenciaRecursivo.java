package ut4;

public class PotenciaRecursivo {
    public static double potencia(double base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }
        if (exponente == 0)
            return 1;
        else if (exponente > 0)
            return base * potencia(base, exponente - 1);
        else
            return 1 / (base * potencia(base, -exponente - 1));
    }
}

