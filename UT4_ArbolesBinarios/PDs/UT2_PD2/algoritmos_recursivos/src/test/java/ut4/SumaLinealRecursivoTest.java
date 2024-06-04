package ut4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SumaLinealRecursivoTest {
    @Test
    public void testSumaLineal() {
        int[] vector1 = {1, 2, 3, 4, 5};
        int[] vector2 = {};
        
        assertEquals(15, SumaLinealRecursivo.SumaLineal(vector1, 5));
        assertEquals(0, SumaLinealRecursivo.SumaLineal(vector2, 0));
        
        Throwable exception = null;
        try {
            SumaLinealRecursivo.SumaLineal(vector1, -5);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        assertEquals("El tamaño del vector es inválido", exception.getMessage());
    }
}
