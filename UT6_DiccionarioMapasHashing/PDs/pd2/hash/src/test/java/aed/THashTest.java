package aed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class THashTest {
    private THashComparaciones tHash;

    @Before
    public void setUp() {
        tHash = new THashComparaciones(10);
    }

    @Test
    public void testInsertar() {
        int indice = tHash.insertar(5);
        assertNotEquals("La inserción falló", -1, indice);
    }

    @Test
    public void testBuscar() {
        tHash.insertar(5);
        int indice = tHash.buscar(5);
        assertNotEquals("La búsqueda falló", -1, indice);
    }

    @Test
    public void testFuncionHashing() {
        int indice = tHash.funcionHashing(5);
        assertEquals("La función de hashing no devolvió el valor esperado", 5, indice);
    }

    @Test
    public void testRedimensionar() {
        for (int i = 0; i < 8; i++) {  // Lleno el 80% de la tabla
            tHash.insertar(i);
        }
        int indice = tHash.insertar(10);  // Esto debería disparar la redimensión
        assertNotEquals("La inserción después de la redimensión falló", -1, indice);
    }
}
