package aed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author diego
 */
public class TCaminos {
    
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()+"\n");
        }
        return sb.toString();
    }
    public String imprimirCaminosConCostoTotal(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append( "Costo total " + camino.getCostoTotal() +  " " + camino.imprimirEtiquetas()+"\n" );

        }
        return sb.toString();
    }

    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }
    public void imprimirCaminosConsolaYCostoTotal(){
        System.out.println(imprimirCaminosConCostoTotal());
    }

    public Collection<TCamino> getCaminos() {

        return caminos;
    }


    //El camino crítico es el camino con mayor costo de toda la colección de caminos
    public TCamino caminoCritico() {
        Double maximoValor = 0.0;
        TCamino resultado = null;
        for(TCamino camino : caminos) {
            if(camino.getCostoTotal() > maximoValor) {
                maximoValor = camino.getCostoTotal();
                resultado = camino;
            }
        }
        return resultado;
    }

    //La holgura es
    public String holgura() {
        TCamino caminoCritico = caminoCritico();
        StringBuilder sb = new StringBuilder();
        for(TCamino camino : caminos) {
            sb.append(camino.imprimirEtiquetas() + "\n");
            sb.append("Costo total del camino:" + " " + camino.getCostoTotal() + "\n");
            sb.append("Holgura" + " " +  (caminoCritico.getCostoTotal() - camino.getCostoTotal()) + "\n");
        }
        return sb.toString();
    }

    public void imprimirHolgurasConsola() {
        System.out.println(holgura());
    }

}