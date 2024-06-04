package ut4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PotenciaRecursivoTest {
    @Test
    public void testPotencia() {
        assertEquals(8, PotenciaRecursivo.potencia(2, 3));

        Throwable exception = null;
        try {
            PotenciaRecursivo.potencia(2, -3);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        assertEquals("El exponente no puede ser negativo", exception.getMessage());
    }
}
