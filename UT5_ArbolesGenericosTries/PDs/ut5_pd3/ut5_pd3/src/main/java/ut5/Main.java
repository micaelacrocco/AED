package ut5;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        TNodoTrie trie = new TNodoTrie();

        
        trie.insertar("hello", 1);
        trie.insertar("world", 1);
        trie.insertar("world", 2);
        trie.insertar("java", 2);

        
        // trie.imprimirPaginas();

        trie.imprimirIndice();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("TA2-triebuscar\\src\\palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir(); 
    
    } 

    
}
