package ut3;

public class Lista<T> implements ILista<T> {
    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato, etiqueta);
        insertar(nuevoNodo);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null && actual.getEtiqueta().compareTo(clave) != 0) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.getEtiqueta().compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null && actual.getSiguiente().getEtiqueta().compareTo(clave) != 0) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() == null) {
            return false;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        return true;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.getEtiqueta()).append(" ");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.getEtiqueta()).append(separador);
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        primero = unNodo;
    }
}