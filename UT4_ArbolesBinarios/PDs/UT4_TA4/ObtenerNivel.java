public class ObtenerNivel {
    public int nivel(int clave) {
        return nivelRecursivo(this.raiz, clave, 0);
    }

    private int nivelRecursivo(Nodo nodo, int clave, int nivelActual) {
        if (nodo == null)
            return -1;
        else if (nodo.valor == clave)
            return nivelActual;
        else if (clave < nodo.valor)
            return nivelRecursivo(nodo.izquierdo, clave, nivelActual + 1);
        else
            return nivelRecursivo(nodo.derecho, clave, nivelActual + 1);

    }
}
