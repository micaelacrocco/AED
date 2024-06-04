package ut3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListaTest {

    @Test
    public void testInsertarYBuscar() {
        Lista<Integer> lista = new Lista<>();
        lista.insertar(1, 10);
        lista.insertar(2, 20);
        lista.insertar(3, 30);

        assertEquals(Integer.valueOf(10), lista.buscar(1).getDato());
        assertEquals(Integer.valueOf(20), lista.buscar(2).getDato());
        assertEquals(Integer.valueOf(30), lista.buscar(3).getDato());
        assertNull(lista.buscar(4));
    }

    @Test
    public void testEliminar() {
        Lista<Integer> lista = new Lista<>();
        lista.insertar(1, 10);
        lista.insertar(2, 20);
        lista.insertar(3, 30);

        assertTrue(lista.eliminar(2));
        assertNull(lista.buscar(2));
        assertFalse(lista.eliminar(5));
    }

    @Test
    public void testImprimir() {
        Lista<Integer> lista = new Lista<>();
        lista.insertar(1, 10);
        lista.insertar(2, 20);
        lista.insertar(3, 30);

        assertEquals("1 2 3 ", lista.imprimir());
        assertEquals("1, 2, 3, ", lista.imprimir(", "));
    }
}

