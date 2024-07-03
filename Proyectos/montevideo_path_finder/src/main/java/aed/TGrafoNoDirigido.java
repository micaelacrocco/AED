package aed;

import java.lang.reflect.Array;
import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido,IGrafoKevinBacon {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<TArista> conjuntoAristas = PrimAuxiliar();
        Collection<TVertice> v = getVertices().values();
        TGrafoNoDirigido grafoMenorCosto = new TGrafoNoDirigido(v,conjuntoAristas);
        return grafoMenorCosto;
    }
    public LinkedList<TArista> PrimAuxiliar() {
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();
        for(TVertice v : getVertices().values()) {
            U.add(v);
            break;
        }
        while(U.size() != V.size()) {
            double menorCosto = Double.MAX_VALUE;
            TArista aristaDeMenorCosto = null;
            LinkedList<TArista> todasLasaristasDelGrafo = this.getLasAristas();
            for(TArista a : todasLasaristasDelGrafo) {
                Set<TVertice> diferencia = new HashSet<>(V);
                diferencia.removeAll(U);
                TVertice origen = buscarVertice(a.etiquetaOrigen);
                TVertice destino = buscarVertice(a.etiquetaDestino);
                if(U.contains(origen) && diferencia.contains(destino) && a.getCosto() < menorCosto && !T.contains(a)) {
                    menorCosto = a.getCosto();
                    aristaDeMenorCosto = a;
                }
            }
            T.add(aristaDeMenorCosto);
            TVertice ver = buscarVertice(aristaDeMenorCosto.etiquetaDestino);
            U.add(ver);
        }
        return T;
    }


    @Override
    public TGrafoNoDirigido Kruskal() {
        return kruskalAuxiliar();
    }

    public TGrafoNoDirigido kruskalAuxiliar() {
        //Creamos el AAM(Arbol abarcador de costo mínimo)
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(), new TAristas());
        TAristas aristasSinOrdenar = lasAristas;

        //Primero ordenamos las aristas de menor a mayor por costo, así no tenemos que estár siempre buscando la menor en cada iteracción

        aristasSinOrdenar.sort((TArista arista1, TArista arista2) -> {
            if(arista1.costo < arista2.costo) {
                return -1;
            } else if(arista1.costo > arista2.costo) {
                return 1;
            } else {
                return 0;
            }
        });

        TAristas aristasOrdenadas = new TAristas();
        aristasOrdenadas.addAll(aristasSinOrdenar);

        int aristasAgregadasAlAMM = 0;

        //Arbol de N VERTICES, n - 1 aristas, SI NO SE AGREGARON TODAS LAS ARISTAS AL AAM
        while(aristasAgregadasAlAMM != getVertices().size() - 1) {
            TArista aristaMinima = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = AAM.getVertices().get(aristaMinima.getEtiquetaOrigen());
            TVertice verticeDestino = AAM.getVertices().get(aristaMinima.getEtiquetaDestino());
            if(!AAM.estanConectados(verticeOrigen.getEtiqueta(), verticeDestino.getEtiqueta())) {
                AAM.insertarArista(aristaMinima);
                //Agrego también la inversa de la arista mínima ya qué para representar una conexión entre dos vértices en un
                //Grafo no dirigido es bidireccional de B a A se representa como B -> A Y A -> B
                AAM.getLasAristas().add(aristaMinima.aristaInversa());
                aristasAgregadasAlAMM++;
            }
        }
        return AAM;
    }

    private boolean estanConectados(Comparable etiquetaVertice1, Comparable etiquetaVertice2) {
        TVertice v = buscarVertice(etiquetaVertice1);
        //Si son  adyacentes(están conectados)
        if(v.buscarAdyacencia(etiquetaVertice2) != null) {
            return true;
        } else {
            return false;
        }
    }



    //HACE BEA A TODOS LOS VÉRTICES, LOS VISITA EN EL ORDEN EN QUE LOS ENCUENTRA
    @Override
    public Collection<TVertice> bea() {
        desvisitarVertices();
        Collection<TVertice> verticesVisitados = new LinkedList<>();
        for(TVertice vertice : getVertices().values()) {
            if(!vertice.getVisitado()) {
                verticesVisitados.addAll(vertice.bea());
            }
        }
        return verticesVisitados;
    }

    //HACE BEA DESDE UN VÉRTICE ESPECÍFICO, VISITA EL PROPIO VÉRTICE, SUS ADYACENTES Y SUS DESCENDIENTES.
    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        Collection<TVertice> verticesVisitados = new LinkedList<>();
        desvisitarVertices();
        TVertice verticeOrigen = getVertices().get(etiquetaOrigen);
        if(verticeOrigen != null) {
            verticesVisitados.addAll(verticeOrigen.bea());
        }
        return verticesVisitados;
    }


     //PUNTOS DE ARTICULACIÓN:
      /*
            ASIGNACIÓN DE BAJO:
             primero procesas los nodos agregandoles un numero BP´, después los recorres en post orden, y te fijas, pueden haber 3 posibilidades:
              1: que el nodo el cuál estés parado, no tenga hijos y no tenga arista de retroceso, en ese caso su bajo es su número bp,
              2: que el nodo el cuál estés parado tenga arista de retroceso, en ese caso su bajo es el bajo de la arista de retroceso,
              3- si el nodo tiene hijos y no arista de retroceso, comparas el numero bp tuyo con el bajo de tu hijo, agarras el menor y ese va a ser tu bajo

            ENCONTRAR UN PUNTO DE ARTICULACIÓN:
            La raiz es un punto de articulación SI Y SOLO SÍ, tiene DOS o MÁS HIJOS

            Un vértice V distinto de la raíz es un punto de articulación SI Y SOLO SÍ, TIENE UN HIJO W el cuál
            BAJO DE W ES MAYOR O IGUAL AL NUMERO BP DE V
         */

	 
	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {

        desvisitarVertices();
        LinkedList<TVertice> puntosDeArticulacion = new LinkedList<>();
        int[] cont = new int[1];

        // Obtener el vértice origen

        TVertice verticeOrigen = getVertices().get(etOrigen);
        if (verticeOrigen != null && !verticeOrigen.getVisitado()) {
            verticeOrigen.puntoDeArticulacion(puntosDeArticulacion, cont);
        }

        // ME ASEGURO DE QUE EL MÉTODO NO DEVUELVA PUNTOS DE ARTICULACIÓN REPETIDOS
        LinkedList<TVertice> puntosDeArticulacionSinRepetir = new LinkedList<>();
        for (TVertice vertice : puntosDeArticulacion) {
            if (!puntosDeArticulacionSinRepetir.contains(vertice)) {
                puntosDeArticulacionSinRepetir.add(vertice);
            }
        }

        return puntosDeArticulacionSinRepetir;
    }
      
    public LinkedList<TVertice> puntosArticulacion() {


        desvisitarVertices();
        LinkedList<TVertice> puntosDeArticulacion = new LinkedList<>();
        int[] cont = new int[1];

        for(TVertice vertice : getVertices().values()) {
            if(!vertice.getVisitado()) {
                vertice.puntoDeArticulacion(puntosDeArticulacion,cont);
            }
        }

        //ME ASEGURO DE QUE EL MÉTODO NO DEVUELVA PUNTOS DE ARTICULACIÓN REPETIDOS
        LinkedList<TVertice> puntosDeArticulacionSinRepetir = new LinkedList<>();

        for(TVertice vertice : puntosDeArticulacion) {
            if(!puntosDeArticulacionSinRepetir.contains(vertice)) {
                puntosDeArticulacionSinRepetir.add(vertice);
            }
        }
        return puntosDeArticulacionSinRepetir;
    }
    
	@Override
    public boolean esConexo(){
        if(getVertices().isEmpty()) { //Si el grafo no tiene vértices, se considera conexo
            return true;
        }
        desvisitarVertices();

        TVertice verticeInicial = getVertices().values().iterator().next();

        //Realizamos bea desde el vértice inicial
        Collection<TVertice> verticesVisitadosEnBea = verticeInicial.bea();

        //Si después de hacer bea algún vertice no fue visitado, entonces el grafo no es conexo.

        for(TVertice vertice : getVertices().values()) {
            if(!vertice.getVisitado()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        TVertice kevinBacon = getVertices().get("Kevin_Bacon");
        if(kevinBacon != null) {
            return kevinBacon.numBacon(actor.toString());
        } else {
            return -1;
        }
    }

}