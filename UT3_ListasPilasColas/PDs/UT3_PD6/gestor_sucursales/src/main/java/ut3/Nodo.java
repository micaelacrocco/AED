package ut3;

public class Nodo<T> implements INodo<T> {

    private T dato;
    private Comparable etiqueta;
    private Object siguiente;

    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
        this.siguiente = null;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return (Nodo<T>) siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(dato + " ");
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(etiqueta + " ");
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

}
