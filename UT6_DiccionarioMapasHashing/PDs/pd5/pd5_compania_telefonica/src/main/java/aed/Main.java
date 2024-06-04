package aed;

import java.util.ArrayList;

public class Main {
    
    public static void Main(String[] args) {

        TTrieHashMap trie = new TTrieHashMap();
        trie.insertar("hola");
        trie.insertar("holanda");
        trie.insertar("avion");
        trie.insertar("avioneta");

        // Pruebas de autocompletar
        System.out.println("Pruebas de autocompletar:");
        ArrayList<String> sugerencias = trie.autocompletar("hol");
        for (String s : sugerencias) {
            System.out.println(s);
        }

        // Pruebas de búsqueda de patrones
        System.out.println("\nPruebas de búsqueda de patrones:");
        String texto = "hola, este es un texto de prueba para probar la búsqueda de patrones";
        String patron = "prueba";
        ArrayList<Integer> posiciones = trie.buscarPatron(texto, patron);
        for (int pos : posiciones) {
            System.out.println("Patrón encontrado en la posición: " + pos);
        }
    }
}



