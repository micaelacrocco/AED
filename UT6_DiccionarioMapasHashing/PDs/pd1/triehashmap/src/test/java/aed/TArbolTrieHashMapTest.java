package aed;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class TArbolTrieHashMapTest {
    TArbolTrieHashMap trie;

    @Before
    public void setUp() {

        trie = new TArbolTrieHashMap();
        
        trie.insertar("hola");
        trie.insertar("holanda");
        trie.insertar("holandes");
        trie.insertar("holgazan");
        trie.insertar("holgazana");
        trie.insertar("holgazanear");
        trie.insertar("holgazaneo");
        trie.insertar("holgazanes");
        trie.insertar("holgazanese");
        trie.insertar("holgazaneses");
    }

    @Test
    public void trie_PalabraEstaEnElTrie()
    {
        int resultado = trie.buscar("hola");
        assertEquals(4, resultado);
    }

    @Test
    public void trie_PalabraNoEstaEnElTrie()
    {
        int resultado = trie.buscar("inexistente");
        assertEquals(1, resultado);
    }        


    @Test
    public void trie_PredecirPrefijoComun()
    {
        assertEquals(Arrays.asList("holgazan", "holgazana", "holgazanear", "holgazanes", "holgazanese", "holgazaneses", "holgazaneo"), trie.predecir("holgazan"));
    }

    @Test
    public void trie_PredecirPrefijoInexistente()
    {
        List<String> resultado = trie.predecir("inexis");
        assertTrue(resultado.isEmpty());
    }
}
