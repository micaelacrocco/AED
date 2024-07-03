package aed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
                TVertice verticeA = new TVertice("A");
                TVertice verticeB = new TVertice("B");
                TVertice verticeC = new TVertice("C");
                TVertice verticeD = new TVertice("D");
                TVertice verticeE  = new TVertice("E");
                TVertice verticeF  = new TVertice("F");
        
                TArista aristaAB = new TArista("A", "B", 4);
                TArista aristaAF = new TArista("A", "F", 2);
                TArista aristaBC = new TArista("B", "C", 6);
                TArista aristaBF = new TArista("B", "F", 3);
                TArista aristaCD = new TArista("C", "D", 8);
                TArista aristaCE = new TArista("C", "E", 5);
                TArista aristaDE = new TArista("D", "E", 1);
                TArista aristaEF = new TArista("E", "F", 7);
        
                Collection<TVertice> vertices = new ArrayList<>();
                vertices.add(verticeA);
                vertices.add(verticeB);
                vertices.add(verticeC);
                vertices.add(verticeD);
                vertices.add(verticeE);
                vertices.add(verticeF);

                LinkedList<TArista> aristas = new LinkedList<>();
                aristas.add(aristaAB);
                aristas.add(aristaAF);
                aristas.add(aristaBC);
                aristas.add(aristaBF);
                aristas.add(aristaCD);
                aristas.add(aristaCE);
                aristas.add(aristaDE);
                aristas.add(aristaEF);
                
                TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        
        
                TGrafoNoDirigido arbolExpansionMinima = grafo.Kruskal();
                TGrafoNoDirigido AAM = grafo.Prim();
        
        
                System.out.println("Aristas del Árbol de Expansión Mínima KRUSKAL:");
                for (TArista arista : arbolExpansionMinima.getLasAristas()) {
                    System.out.println(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() + " : " + arista.getCosto());
                }
        
                System.out.println("Aristas del Árbol de Expansión Mínima PRIM:");
                for (TArista arista : AAM.getLasAristas()) {
                    System.out.println(arista.getEtiquetaOrigen() + " - " + arista.getEtiquetaDestino() + " : " + arista.getCosto());
                }
    }
}