package ut3;

public class Main {
    public static void main(String[] args) {

        ILista<Integer> lista = new Lista<>();

        lista.insertar(1, 10);
        lista.insertar(2, 20);
        lista.insertar(3, 30);

        System.out.println("Lista actual: " + lista.imprimir());

        Comparable claveBuscada = 2;
        Nodo<Integer> nodoEncontrado = lista.buscar(claveBuscada);
        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.getDato());
        } else {
            System.out.println("Nodo con clave " + claveBuscada + " no encontrado.");
        }

        Comparable claveAEliminar = 2;
        boolean eliminado = lista.eliminar(claveAEliminar);
        if (eliminado) {
            System.out.println("Nodo con clave " + claveAEliminar + " eliminado.");
        } else {
            System.out.println("No se pudo eliminar el nodo con clave " + claveAEliminar + ".");
        }

        System.out.println("Lista actualizada: " + lista.imprimir());

        System.out.println("¿La lista está vacía? " + (lista.esVacia() ? "Sí" : "No"));

        System.out.println("Cantidad de elementos en la lista: " + lista.cantElementos());
    }
}

