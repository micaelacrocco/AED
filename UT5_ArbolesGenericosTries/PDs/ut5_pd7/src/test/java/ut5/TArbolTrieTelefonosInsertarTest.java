package ut5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TArbolTrieTelefonosInsertarTest {

    private TArbolTrieTelefonos trie;

    @BeforeEach
    void setUp() {
        trie = new TArbolTrieTelefonos();
    }

    @Test
    void testInsertarUnAbonado() {
        TAbonado abonado = new TAbonado("Juan Perez", "123456789");
        trie.insertar(abonado);
        
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("123", "456");
        assertNotNull(resultados);
        assertEquals(1, resultados.size());
        assertEquals("Juan Perez", resultados.getFirst().getNombre());
        assertEquals("123456789", resultados.getFirst().getTelefono());
    }

    @Test
    void testInsertarAbonadosDuplicados() {
        TAbonado abonado1 = new TAbonado("Juan Perez", "123456789");
        TAbonado abonado2 = new TAbonado("Juan Perez", "123456789");
        trie.insertar(abonado1);
        trie.insertar(abonado2);
        
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("123", "456");
        assertNotNull(resultados);
        assertEquals(1, resultados.size()); 
    }

    @Test
    void testInsertarMultiplesAbonados() {
        TAbonado abonado1 = new TAbonado("Juan Perez", "123456789");
        TAbonado abonado2 = new TAbonado("Maria Lopez", "987654321");
        TAbonado abonado3 = new TAbonado("Carlos Sanchez", "555555555");
        trie.insertar(abonado1);
        trie.insertar(abonado2);
        trie.insertar(abonado3);

        LinkedList<TAbonado> resultados1 = trie.buscarTelefonos("123", "456");
        assertNotNull(resultados1);
        assertEquals(1, resultados1.size());
        assertEquals("Juan Perez", resultados1.getFirst().getNombre());
        assertEquals("123456789", resultados1.getFirst().getTelefono());

        LinkedList<TAbonado> resultados2 = trie.buscarTelefonos("987", "654");
        assertNotNull(resultados2);
        assertEquals(1, resultados2.size());
        assertEquals("Maria Lopez", resultados2.getFirst().getNombre());
        assertEquals("987654321", resultados2.getFirst().getTelefono());

        LinkedList<TAbonado> resultados3 = trie.buscarTelefonos("555", "555");
        assertNotNull(resultados3);
        assertEquals(1, resultados3.size());
        assertEquals("Carlos Sanchez", resultados3.getFirst().getNombre());
        assertEquals("555555555", resultados3.getFirst().getTelefono());
    }

    @Test
    void testInsertarAbonadoSinTelefono() {
        TAbonado abonado = new TAbonado("Juan Perez", "");
        trie.insertar(abonado);

        LinkedList<TAbonado> resultados = trie.buscarTelefonos("", "");
        assertNotNull(resultados);
        
        boolean found = false;
        for (TAbonado a : resultados) {
            if (a.getNombre().equals("Juan Perez") && a.getTelefono().isEmpty()) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    void testInsertarAbonadoSinNombre() {
        TAbonado abonado = new TAbonado("", "123456789");
        trie.insertar(abonado);

        LinkedList<TAbonado> resultados = trie.buscarTelefonos("123", "456");
        assertNotNull(resultados);

        boolean found = false;
        for (TAbonado a : resultados) {
            if (a.getNombre().isEmpty() && a.getTelefono().equals("123456789")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
}
