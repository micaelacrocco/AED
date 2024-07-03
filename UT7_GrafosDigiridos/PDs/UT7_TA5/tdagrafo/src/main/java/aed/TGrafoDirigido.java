package aed;


import jdk.jshell.execution.Util;

import javax.naming.spi.InitialContextFactory;
import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private final LinkedList<TArista> aristas; //Aristas del grafo
    private static final double INFINITO = Double.POSITIVE_INFINITY;
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        this.aristas = new LinkedList<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if(nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }
    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }
    /**
     * @return the aristas
     */
    public LinkedList<TArista> getAristas() {
        return aristas;
    }

    @Override
    public void desvisitarVertices() {
        for(TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    @Override
    public Comparable centroDelGrafo() {
        /*
        Para obtener el centro de un grafo hacer:
        – aplicar Floyd para obtener el largo de los caminos,
        – encontrar el máximo valor en cada columna i, y con ello se obtiene la excentricidad de i,
        – encontrar el vértice con excentricidad mínima: el
        centro de G
         */
        //Inicializamos a la excentricidad minima con el valor máximo que puede tener un double, para asegurarnos que en la primera iteracción
        //la excentricidad calculada sea menor a ese valor.

        Comparable etiquetaVerticeCentro = null;
        double excentricidadMinima = Double.MAX_VALUE;

        for(Map.Entry<Comparable,Double> entry : obtenerExentricidadesGrafo().entrySet()) {
            if(excentricidadMinima > entry.getValue()) {
                excentricidadMinima = entry.getValue();
                etiquetaVerticeCentro = entry.getKey();
            }
        }
        return etiquetaVerticeCentro;
    }

    private Map<Comparable, Double> obtenerExentricidadesGrafo() {
        Map<Comparable,Double> resultado = new HashMap<>();
        Double[][] matrizFloyd = floyd();
        Comparable[] etiquetas = new Comparable[vertices.size()];
        int i = 0;
        for(Comparable clave : vertices.keySet()) {
            etiquetas[i] = clave;
            i++;
        }

        for(int col = 0; col < vertices.size(); col++) {
            Double maximoValorEnI = 0.0;
            for(int fil = 0; fil < vertices.size(); fil++) {
                if(maximoValorEnI < matrizFloyd[fil][col]) {
                    maximoValorEnI = matrizFloyd[fil][col];
                }
            }
            resultado.put(etiquetas[col], maximoValorEnI);
        }
        return resultado;
    }

    @Override
    public Double[][] floyd() {
        /*
         int n = vertices.size();
        Double[][] matrizCaminosMasCortos = new Double[n][n];

        //Almacenamos las claves de los vértices para así acceder a la clave i y j
        List<Comparable> etiquetasVertices = new ArrayList<>(vertices.keySet());

        //FORMAMOS LA MATRIZ
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) { //El vértice de origen y el vértice de destino son los mismos, por ende el camino tiene costo 0.
                   matrizCaminosMasCortos[i][j] = 0.0;
                } else{
                    //Obtenemos los costos de las aristas
                    TVertice verticeOrigen = vertices.get(etiquetasVertices.get(i));
                    TVertice verticeDestino = vertices.get(etiquetasVertices.get(j));
                    Double costoArista = verticeOrigen.obtenerCostoAdyacencia(verticeDestino);

                    //Existe una arista directa
                    if(costoArista != Double.MAX_VALUE) {
                        matrizCaminosMasCortos[i][j] = costoArista;
                    } else {
                        matrizCaminosMasCortos[i][j] = INFINITO;
                    }
                }
            }
        }
         */
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(vertices);

        //ALGORITMO DE FLOYD-WARSHALL

        for(int k = 0; k < vertices.size(); k++) {
            for(int i = 0; i < vertices.size(); i++) {
                for(int j = 0; j < vertices.size(); j++) {
                    if((matriz[i][k] + matriz[k][j]) < matriz[i][j]) {
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                    }
                }
            }
        }

        return matriz;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        return obtenerExentricidadesGrafo().get(etiquetaVertice);
    }

    @Override
    public boolean[][] warshall() {
        int n = vertices.size();
        boolean[][] matrizCaminosWarshall = new boolean[n][n];

        //Almacenamos las claves de los vértices para así acceder a la clave i y j
        List<Comparable> etiquetasVertices = new ArrayList<>(vertices.keySet());

        //FORMAMOS LA MATRIZ
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) { //El vértice de origen y el vértice de destino son los mismos, por ende el camino tiene costo 0.
                    matrizCaminosWarshall[i][j] = true;
                } else{
                    //Obtenemos los costos de las aristas
                    TVertice verticeOrigen = vertices.get(etiquetasVertices.get(i));
                    TVertice verticeDestino = vertices.get(etiquetasVertices.get(j));
                    Double costoArista = verticeOrigen.obtenerCostoAdyacencia(verticeDestino);
                    //Existe una arista directa(existe un camino directo)
                    if(costoArista != Double.MAX_VALUE) {
                        matrizCaminosWarshall[i][j] = true;
                    } else {
                        //No existe un camino directo
                        matrizCaminosWarshall[i][j] = false;
                    }
                }
            }
        }

        //Algoritmo de Warshall

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!matrizCaminosWarshall[i][j]) {
                        matrizCaminosWarshall[i][j] = matrizCaminosWarshall[i][k] && matrizCaminosWarshall[k][j];
                    }
                }
            }
        }
        return matrizCaminosWarshall;
    }


    public void bpf() {
        //Al principio marcamos todos los vértices como no visitados
        for(TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        for(TVertice vertice : vertices.values()) {
            if(!vertice.getVisitado()) {
                bpfAuxiliar(vertice);
            }
        }
    }
    public void bpfConVerticeInicial(TVertice verticeInicial) {
        //Al principio marcamos todos los vértices como no visitados
        for(TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        bpfAuxiliar(verticeInicial);

        for(TVertice vertice : vertices.values()) {
                if(!vertice.getVisitado()) {
                bpfAuxiliar(vertice);
            }
        }
    }

    public void bpfConEtiquetaVerticeInicial(Comparable etiquetaVerticeInicial) {
        TVertice verticeInicial = this.buscarVertice(etiquetaVerticeInicial);
        if(verticeInicial == null) {
            System.out.println("No existe este vértice en el grafo");
        }
        for(TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        bpfAuxiliar(verticeInicial);

        for(TVertice vertice : vertices.values()) {
            if(!vertice.getVisitado()) {
                bpfAuxiliar(vertice);
            }
        }
    }

    private void bpfAuxiliar(TVertice vertice) {
        //Visitamos el vértice inicial
        vertice.setVisitado(true);
        System.out.println("Visitando vértice" +  " " + vertice.getEtiqueta());
        for(Object objadyacencia : vertice.getAdyacentes()) {
            if(objadyacencia instanceof TAdyacencia) {
                TAdyacencia adyacencia = (TAdyacencia) objadyacencia;
                TVertice adyacente = adyacencia.getDestino();

                if(!adyacencia.getDestino().getVisitado()) {
                    bpfAuxiliar(adyacente);
                }
            }
        }
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if(v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }
    private void bpfAuxiliarHastaDestino(TVertice origen,TVertice destino,ArrayList<Comparable> caminoActual, ArrayList<ArrayList<Comparable>> caminos) {
        //Visitamos el vértice inicial
        origen.setVisitado(true);

        caminoActual.add(origen.getEtiqueta());

        if(origen.getEtiqueta().equals(destino.getEtiqueta())) {
            caminos.add(new ArrayList<>(caminoActual));
        } else {
            for(Object objadyacencia : origen.getAdyacentes()) {
                if(objadyacencia instanceof TAdyacencia) {
                    TAdyacencia adyacencia = (TAdyacencia) objadyacencia;
                    TVertice adyacente = adyacencia.getDestino();
                    if(!adyacencia.getDestino().getVisitado()) {
                        bpfAuxiliarHastaDestino(adyacente,destino, caminoActual, caminos);
                    }
                }
            }
        }

    }
    public List<TVertice> ordenarTopologico() {
        Stack<TVertice> pila = new Stack<>();
        Set<TVertice> visitado = new HashSet<>();
        for(TVertice vertice : vertices.values()) {
            if(!vertice.getVisitado()) {
                vertice.bpfParaOrdenTopologico(vertice,visitado,pila);
            }
        }

        List<TVertice> resultado = new ArrayList<>();
        while(!pila.isEmpty()) {
            resultado.add(pila.pop());
        }
        return resultado;
    }


    public boolean esFuertementeConexo() {
        if (getVertices().isEmpty()) { // Si el grafo no tiene vértices, se considera fuertemente conexo
            return true;
        }

        desvisitarVertices();
        TVertice verticeInicial = getVertices().values().iterator().next();

        // Realizamos BEA desde el vértice inicial
        Collection<TVertice> verticesVisitadosEnBea = verticeInicial.bea();

        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                return false; // Si algún vértice no fue visitado, el grafo no es fuertemente conexo
            }
        }

        TGrafoDirigido grafoTranspuesto = obtenerGrafoTranspuesto();

        grafoTranspuesto.desvisitarVertices();

        // Realizamos BEA desde el vértice correspondiente en el grafo transpuesto
        TVertice verticeInicialTranspuesto = grafoTranspuesto.getVertices().get(verticeInicial.getEtiqueta());
        Collection<TVertice> verticesVisitadosEnBeaTranspuesto = verticeInicialTranspuesto.bea();

        for (TVertice vertice : grafoTranspuesto.getVertices().values()) {
            if (!vertice.getVisitado()) {
                return false; // Si algún vértice no fue visitado en el grafo transpuesto, el grafo no es fuertemente conexo
            }
        }

        return true; // Si todos los vértices fueron visitados en ambas BEA, el grafo es fuertemente conexo
    }

    // Método auxiliar para obtener el grafo transpuesto
    private TGrafoDirigido obtenerGrafoTranspuesto() {
        Collection<TVertice> verticesTranspuestos = new ArrayList<>();
        for (TVertice vertice : getVertices().values()) {
            verticesTranspuestos.add(new TVertice(vertice.getEtiqueta()));
        }

        Collection<TArista> aristasTranspuestas = new ArrayList<>();
        for (TVertice vertice : getVertices().values()) {
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();
            for (TAdyacencia adyacencia : adyacentes) {
                aristasTranspuestas.add(new TArista(adyacencia.getDestino().getEtiqueta(), vertice.getEtiqueta(), adyacencia.getCosto()));
            }
        }

        return new TGrafoDirigido(verticesTranspuestos, aristasTranspuestas);
    }


    //Algoritmo de tarjan para encontrar los componentes fuertemente conexos en un grafo dirigido.
    public List<List<TVertice>> encontrarComponentesFuertementeConectados() {
        List<List<TVertice>> componentes = new ArrayList<>();
        Map<TVertice, Integer> indices = new HashMap<>();
        Map<TVertice, Integer> bajos = new HashMap<>();
        Deque<TVertice> pila = new ArrayDeque<>();
        Set<TVertice> enPila = new HashSet<>();
        int[] index = {0};

        for (TVertice vertice : getVertices().values()) {
            if (!indices.containsKey(vertice)) {
                fuertementeConexo(vertice, index, indices, bajos, pila, enPila, componentes);
            }
        }
        return componentes;
    }

    private void fuertementeConexo(TVertice v, int[] index, Map<TVertice, Integer> indices, Map<TVertice, Integer> bajos,
                               Deque<TVertice> pila, Set<TVertice> enPila, List<List<TVertice>> componentes) {
        indices.put(v, index[0]);
        bajos.put(v, index[0]);
        index[0]++;
        pila.push(v);
        enPila.add(v);

        LinkedList<TAdyacencia> adyacentes = v.getAdyacentes();
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice w = adyacencia.getDestino();
            if (!indices.containsKey(w)) {
                fuertementeConexo(w, index, indices, bajos, pila, enPila, componentes);
                bajos.put(v, Math.min(bajos.get(v), bajos.get(w)));
            } else if (enPila.contains(w)) {
                bajos.put(v, Math.min(bajos.get(v), indices.get(w)));
            }
        }

        if (bajos.get(v).equals(indices.get(v))) {
            List<TVertice> componente = new ArrayList<>();
            TVertice w;
            do {
                w = pila.pop();
                enPila.remove(w);
                componente.add(w);
            } while (!w.equals(v));
            componentes.add(componente);
        }
    }

    //Clasificar arcos:

    public void clasificarArcos(Comparable origen, List<TArista> arcosArbol, List<TArista> arcosRetroceso, List<TArista> arcosAvance, List<TArista> arcosCruzados) {
        TVertice vertOrigen = buscarVertice(origen);
        if (vertOrigen == null) {
            return;
        }
        desvisitarVertices();
        asignaNumBpf(origen);
        desvisitarVertices();
        cantDescendientes(origen);
        desvisitarVertices();
        vertOrigen.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
            }
        }
    }

    public void asignaNumBpf(Comparable origen) {
        TVertice v = buscarVertice(origen);
        if (v == null) {
            return;
        }
        int num = v.asignaNumBpf(1);
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                num = vertice.asignaNumBpf(num);
            }
        }
    }

    public void cantDescendientes(Comparable origen) {
        TVertice v = buscarVertice(origen);
        if (v == null) {
            return;
        }
        v.cantDescendientes();
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.cantDescendientes();
            }
        }
    }

    public LinkedList<String> ordenParcial() {
        desvisitarVertices();
        LinkedList<String> resultado = new LinkedList<>();
        Set<TVertice> verticesVisitados = new HashSet<>();

        for(TVertice vertice : vertices.values()) {
            if(!verticesVisitados.contains(vertice)) {
                vertice.ordenParcial(verticesVisitados,resultado);
            }
        }
        return resultado;
    }

    public void listarTareas (LinkedList<String> orden) {
        for(String tarea : orden) {
            System.out.println(tarea);
        }
    }
}