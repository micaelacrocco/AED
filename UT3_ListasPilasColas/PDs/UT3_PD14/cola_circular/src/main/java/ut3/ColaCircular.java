package ut3;

public class ColaCircular<T> implements IColaCircular<T>{
    private T[] elementos;
    private int punteroInicial, punteroFinal, nElementos, capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[this.capacidad];
        this.punteroInicial = 0;
        this.punteroFinal = 0;
        this.nElementos = 0;
    }

    public void agregarACola(T nuevoElemento){
        if(!estaLlena()){
            this.elementos[posicionNuevoElemento()] = nuevoElemento;
            this.nElementos++;

            if(this.punteroFinal < this.capacidad) {
                this.punteroFinal++;
            } else {
                this.punteroFinal = 0;
            }
        } else {
            System.out.println("La cola circular está llena.");
        }
    }

    public T sacarDeCola() {
        if (!estaVacia()) {
            T elemento = this.elementos[this.punteroInicial];
            this.nuevaPosicionInicial();
            this.nElementos--;
            return elemento;
        } else {
            System.out.println("La cola circular está vacía.");
            return null;
        }
    }

    private void nuevaPosicionInicial() {
        this.punteroInicial = (this.punteroInicial + 1) % this.capacidad;
    }

    private int posicionNuevoElemento() {
        return (this.punteroInicial + this.nElementos) % capacidad;
    }

    public boolean estaVacia() {
        return (this.nElementos == 0);
    }

    public boolean estaLlena() {
        return (this.nElementos == this.capacidad);
    }
}
