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

        TGrafoDirigido grafo=UtilGrafos.cargarGrafo("PDs\\UT7_PD3\\pd3\\src\\main\\java\\aed\\aeropuertos.txt", "PDs\\UT7_PD3\\pd3\\src\\main\\java\\aed\\conexiones.txt", false, TGrafoDirigido.class);
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "VUELE SEGURO");

        Object[] etiquetasarray = grafo.getEtiquetasOrdenado();

        Double[][] mfloyd = grafo.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, grafo.getVertices(), "matriz floyd");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + grafo.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();

        TCaminos todosLosCaminos = grafo.todosLosCaminos("Montevideo","Curitiba");
        todosLosCaminos.imprimirCaminos();
        todosLosCaminos.imprimirCaminosConsola();

        TCaminos todosLosCaminos1 = grafo.todosLosCaminos("Porto_Alegre","Santos");
        todosLosCaminos1.imprimirCaminos();
        todosLosCaminos1.imprimirCaminosConsola();

        grafo.bpf();

        System.out.println();

        TVertice verticeInicial = grafo.getVertices().get("Montevideo");
        if (verticeInicial != null) {
            grafo.bpfConVerticeInicial(verticeInicial);
        }
    }
}