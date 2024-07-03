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
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_2.txt", "./src/conexiones_2.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        TCaminos todosLosCaminos = gd.todosLosCaminos("Buenos_Aires","Montevideo");

        todosLosCaminos.imprimirCaminosConsolaYCostoTotal();


        TCamino caminoCritico = todosLosCaminos.caminoCritico();
        System.out.println("Camino crítico: " + caminoCritico.imprimirEtiquetas());
        System.out.println("Costo total del camino crítico: " + caminoCritico.getCostoTotal());

        todosLosCaminos.imprimirHolgurasConsola();
    }
}