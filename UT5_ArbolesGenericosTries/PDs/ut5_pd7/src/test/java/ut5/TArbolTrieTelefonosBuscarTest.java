package ut5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

class TArbolTrieTelefonosBuscarTest {

    private TArbolTrieTelefonos trie;

    @BeforeEach
    void setUp() {
        trie = new TArbolTrieTelefonos();

        trie.insertar(new TAbonado("Juan Perez", "123456789"));
        trie.insertar(new TAbonado("Maria Lopez", "987654321"));
        trie.insertar(new TAbonado("Carlos Sanchez", "555555555"));
        trie.insertar(new TAbonado("Ana Gomez", "123123123"));
    }

    @Test
    void testBuscarTelefonosExistente() {
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("123", "45");
        
        assertNotNull(resultados);
        assertEquals(1, resultados.size());
        TAbonado abonado = resultados.getFirst();
        assertEquals("Juan Perez", abonado.getNombre());
        assertEquals("123456789", abonado.getTelefono());
    }

    @Test
    void testBuscarTelefonosNoExistente() {
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("999", "99");
        
        assertNotNull(resultados);
        assertEquals(0, resultados.size());
    }

    @Test
    void testBuscarTelefonosVariosResultados() {
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("123", "");
        
        assertNotNull(resultados);
        assertEquals(2, resultados.size());

        boolean foundJuan = false;
        boolean foundAna = false;
        for (TAbonado abonado : resultados) {
            if (abonado.getNombre().equals("Juan Perez") && abonado.getTelefono().equals("123456789")) {
                foundJuan = true;
            } else if (abonado.getNombre().equals("Ana Gomez") && abonado.getTelefono().equals("123123123")) {
                foundAna = true;
            }
        }
        assertTrue(foundJuan);
        assertTrue(foundAna);
    }

    @Test
    void testBuscarTelefonosConAreaVacia() {
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("", "45");
        
        assertNotNull(resultados);
        assertEquals(0, resultados.size());
    }

    @Test
    void testBuscarTelefonosConPaisYAreaVacios() {
        LinkedList<TAbonado> resultados = trie.buscarTelefonos("", "");
        
        assertNotNull(resultados);
        assertEquals(4, resultados.size());
        
        boolean foundJuan = false;
        boolean foundMaria = false;
        boolean foundCarlos = false;
        boolean foundAna = false;
        for (TAbonado abonado : resultados) {
            if (abonado.getNombre().equals("Juan Perez") && abonado.getTelefono().equals("123456789")) {
                foundJuan = true;
            } else if (abonado.getNombre().equals("Maria Lopez") && abonado.getTelefono().equals("987654321")) {
                foundMaria = true;
            } else if (abonado.getNombre().equals("Carlos Sanchez") && abonado.getTelefono().equals("555555555")) {
                foundCarlos = true;
            } else if (abonado.getNombre().equals("Ana Gomez") && abonado.getTelefono().equals("123123123")) {
                foundAna = true;
            }
        }
        assertTrue(foundJuan);
        assertTrue(foundMaria);
        assertTrue(foundCarlos);
        assertTrue(foundAna);
    }
}

