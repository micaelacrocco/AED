public class ObtenerCantHojas {
    // Método para obtener la cantidad de hojas del árbol
    public int cantidadHojas() {
        return cantidadHojasRecursivo(this.raiz);
    }

    private int cantidadHojasRecursivo(Nodo nodo) {
        if (nodo == null)
            return 0;
        else if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;
        else
            return cantidadHojasRecursivo(nodo.izquierdo) + cantidadHojasRecursivo(nodo.derecho);
    }
}
