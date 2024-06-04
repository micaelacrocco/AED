package ut3;

public interface IColaCircular<T> {
    void agregarACola(T nuevoElemento);
    T sacarDeCola();
    boolean estaVacia();
    boolean estaLlena();
}
