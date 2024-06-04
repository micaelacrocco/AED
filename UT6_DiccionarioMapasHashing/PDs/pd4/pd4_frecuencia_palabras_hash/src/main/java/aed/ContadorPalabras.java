package aed;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContadorPalabras {
        public static void contarPalabras(String[] texto) {
        
        HashMap<String, Integer> tabla = new HashMap<>();
        LinkedList<Map.Entry<String, Integer>> listaOrdenada = new LinkedList<>();
        for (String palabra : texto){
            int indice = tabla.getOrDefault(palabra, -1);
            if (indice == -1){ 
                tabla.put(palabra, 1);
                 insertarOrdenado(listaOrdenada, new AbstractMap.SimpleEntry<>(palabra, 1));
            }

            if (indice > -1){
                tabla.put(palabra, tabla.get(palabra) + 1);
                actualizarOrdenado(listaOrdenada, palabra, tabla.get(palabra));
            }
        
        }
        System.out.println("Las 10 palabras que más ocurren:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            if (count++ >= 10) break;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
       
    }

    private static void insertarOrdenado(LinkedList<Map.Entry<String, Integer>> lista, Map.Entry<String, Integer> nuevaEntrada) {
        int index = 0;
        for (Map.Entry<String, Integer> entry : lista) {
            if (nuevaEntrada.getValue() > entry.getValue()) {
                break;
            }
            index++;
        }
        lista.add(index, nuevaEntrada);
    }

    private static void actualizarOrdenado(LinkedList<Map.Entry<String, Integer>> lista, String palabra, int nuevaFrecuencia) {
        int index = 0;
        for (Map.Entry<String, Integer> entry : lista) {
            if (entry.getKey().equals(palabra)) {
                lista.remove(index);
                break;
            }
            index++;
        }
        insertarOrdenado(lista, new AbstractMap.SimpleEntry<>(palabra, nuevaFrecuencia));
    }
}
