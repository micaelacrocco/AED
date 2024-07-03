package aed;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice<T> implements IVertice,IVerticeKevinBacon {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }

    public void bpf() {
        //Visitamos el vértice de origen
        this.setVisitado(true);
        for(TAdyacencia w : this.getAdyacentes()) {
            TVertice adyacente = w.getDestino();

            if(!adyacente.getVisitado()) {
                //Mostramos en consola la etiqueta del vértice antes de visitarlo.
                System.out.println(adyacente.getEtiqueta());
                adyacente.bpf();
            }
        }
    }
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);

        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();

            if (!destino.getVisitado()) {

                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia); // Agregar el camino encontrado a todosLosCaminos
                } else {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, copia, todosLosCaminos); // Llamar recursivamente para el siguiente vértice
                }
            }
        }

        this.setVisitado(false);
        return todosLosCaminos;
    }

    //KEVIN BACON

    private int numBacon;

    @Override
    public int getBacon() {
        return numBacon;
    }

    @Override
    public void setBacon(int newBacon) {
        numBacon = newBacon;
    }

    //Cálculo del número BACON
    //Realizamos búsqueda en amplitud
    public int numBacon(String actorDestino) {
        Queue<TVertice> colaActores = new LinkedList<>();
        //Empezamos siempre por kevin bacon
        this.setVisitado(true);
        colaActores.offer(this);
        setBacon(0);
        while(!colaActores.isEmpty()) {
            TVertice x = colaActores.remove();
            LinkedList<TAdyacencia> adyacentes = x.getAdyacentes();
            for(TAdyacencia y : adyacentes) {
                TVertice verticeAdyacente = y.getDestino();
                if(!verticeAdyacente.getVisitado()) {
                    verticeAdyacente.setVisitado(true);
                    verticeAdyacente.setBacon(x.getBacon() + 1);
                    if(verticeAdyacente.getEtiqueta().equals(actorDestino)) {
                        return verticeAdyacente.getBacon();
                    }
                    colaActores.offer(verticeAdyacente);
                }
            }
        }
        return -1; //Si no se pudo llegar al destino, devolvemos -1
    }

    public Collection<TVertice> bea() {
        Queue<TVertice> colaVertices = new LinkedList<>();
        Collection<TVertice> visitados = new LinkedList<>();
        this.setVisitado(true);
        colaVertices.offer(this);
        visitados.add(this);
        while(!colaVertices.isEmpty()) {
            TVertice x = colaVertices.remove();
            LinkedList<TAdyacencia> adyacentes = x.getAdyacentes();
            for(TAdyacencia y : adyacentes) {
                TVertice verticeAdyacente = y.getDestino();
                if(!verticeAdyacente.getVisitado()) {
                    verticeAdyacente.setVisitado(true);
                    colaVertices.offer(verticeAdyacente);
                    visitados.add(verticeAdyacente);
                }
            }
        }
        return visitados;
    }

    //LÓGICA DEL ALGORITMO DE TARJAN PARA ENCONTRAR LOS PUNTOS DE ARTICULACIÓN:

    public int numBajo;
    public int numBp;
    public void puntoDeArticulacion(LinkedList<TVertice> puntosdeArticulacion, int[] contador) {
        this.setVisitado(true);
        contador[0]++;
        this.numBp = contador[0];
        this.numBajo = contador[0];
        int numeroHijos = 0;

        LinkedList<TVertice> hijos = new LinkedList<>();

        for(TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice adyacente = adyacencia.getDestino();

            if(!adyacente.getVisitado()) {
                numeroHijos++;
                adyacente.puntoDeArticulacion(puntosdeArticulacion,contador);
                hijos.add(adyacente);

                this.numBajo = Math.min(this.numBajo, adyacente.numBajo);

                //ENCONTRAMOS UN VÉRTICE DISTINTO DE LA RAÍZ QUE ES PUNTO DE ARTICULACIÓN
                if(this.numBp <= adyacente.numBajo) {
                    puntosdeArticulacion.add(this);
                }
            } else {
                this.numBajo = Math.min(this.numBajo, adyacente.numBajo);
            }
            //CASO EN EL QUE AL RAÍZ ES UN PUNTO DE ARTICULACIÓN
            if(numeroHijos >= 2 && this.numBp == 1) {
                puntosdeArticulacion.add(this);
            }
        }
    }
}
