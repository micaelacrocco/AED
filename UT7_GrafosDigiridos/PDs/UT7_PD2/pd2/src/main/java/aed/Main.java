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
        // System.out.println( "Hello World!" );

        // Colecciones de vértices y aristas
        ArrayList<TVertice> vertices = new ArrayList();
        ArrayList<TArista> aristas = new ArrayList();

        // Creo los vertices.
        TVertice verticeArtigas = new TVertice("Artigas");
        TVertice verticeCanelones = new TVertice("Canelones");
        TVertice verticeDurazno = new TVertice("Durazno");
        TVertice verticeFlorida = new TVertice("Florida");
        TVertice verticeMontevideo = new TVertice<>("Montevideo");
        TVertice verticePdeE= new TVertice<>("PdeE");
        TVertice verticeRocha = new TVertice<>("Rocha");
        TVertice verticeColonia = new TVertice<>("Colonia");

        // Agrego los vertices a la colección.
        vertices.add(verticeArtigas);
        vertices.add(verticeCanelones);
        vertices.add(verticeDurazno);
        vertices.add(verticeFlorida);
        vertices.add(verticeMontevideo);
        vertices.add(verticePdeE);
        vertices.add(verticeRocha);
        vertices.add(verticeColonia);

        // Creo las aristas.
        TArista aristaArtigasRocha = new TArista(verticeArtigas.getEtiqueta(), verticeRocha.getEtiqueta(), 400);
        TArista aristaCanelonesArtigas = new TArista(verticeCanelones.getEtiqueta(), verticeArtigas.getEtiqueta(), 500);
        TArista aristaCanelonesColonia = new TArista(verticeCanelones.getEtiqueta(), verticeColonia.getEtiqueta(), 200);
        TArista aristaCanelonesDurazno = new TArista(verticeCanelones.getEtiqueta(), verticeDurazno.getEtiqueta(), 170);
        TArista aristaCanelonesPdeE = new TArista(verticeCanelones.getEtiqueta(), verticePdeE.getEtiqueta(), 90);
        TArista aristaColoniaMontevideo = new TArista(verticeColonia.getEtiqueta(), verticeMontevideo.getEtiqueta(), 180);
        TArista aristaFloridaDurazno = new TArista(verticeFlorida.getEtiqueta(), verticeDurazno.getEtiqueta(), 60);
        TArista aristaMontevideoArtigas = new TArista(verticeMontevideo.getEtiqueta(), verticeArtigas.getEtiqueta(), 700);
        TArista aristaMontevideoCanelones = new TArista(verticeMontevideo.getEtiqueta(), verticeCanelones.getEtiqueta(), 30);
        TArista aristaMontevideoPdeE = new TArista(verticeMontevideo.getEtiqueta(), verticePdeE.getEtiqueta(), 130);
        TArista aristaPdeERocha = new TArista(verticePdeE.getEtiqueta(), verticeRocha.getEtiqueta(), 90);
        TArista aristaRochaMontevideo = new TArista(verticeRocha.getEtiqueta(), verticeMontevideo.getEtiqueta(), 270);

        // Agrego las aristas a la colección.
        aristas.add(aristaArtigasRocha);
        aristas.add(aristaCanelonesArtigas);
        aristas.add(aristaCanelonesColonia);
        aristas.add(aristaCanelonesDurazno);
        aristas.add(aristaCanelonesPdeE);
        aristas.add(aristaColoniaMontevideo);
        aristas.add(aristaFloridaDurazno);
        aristas.add(aristaMontevideoArtigas);
        aristas.add(aristaMontevideoCanelones);
        aristas.add(aristaMontevideoPdeE);
        aristas.add(aristaPdeERocha);
        aristas.add(aristaRochaMontevideo);

        // Creo una instancia de grafo dirigido.
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        // Usando la clase utilGrafos Produzco la matriz de adyacencia y la imprimo.
      /*   Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Ejercicio 1");

        Double[][] resultado = grafo.floyd();
        UtilGrafos.imprimirMatriz(resultado, grafo.getVertices());
        */

        Object[] etiquetasarray = grafo.getEtiquetasOrdenado();
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + grafo.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + grafo.centroDelGrafo());
    }
}