package ut4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test; 

public class FactorialRecursivoTest {
    @Test
    public void testFactorial() {
        assertEquals(24, FactorialRecursivo.factorial(4));
        assertEquals(120, FactorialRecursivo.factorial(5));
        assertEquals(1, FactorialRecursivo.factorial(0));
        
        // Test para un número negativo
        Throwable exception = null;
        try {
            FactorialRecursivo.factorial(-3);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        assertEquals("El número no puede ser negativo", exception.getMessage());
    }
}
